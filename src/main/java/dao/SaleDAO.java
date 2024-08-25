package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Employee;
import model.Sale;
import util.JDBCutil;

public class SaleDAO {

    public static ArrayList<Sale> selectSaleByBranch(String branchId) {
        ArrayList<Sale> saleList = new ArrayList();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select sale_id, branch.branch_id, target_value, start_time, deadline, sta_tus"
                    + " from sale inner join branch on sale.branch_id = branch.branch_id"
                    + " where branch.branch_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, branchId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String saleId = rs.getString("sale_id");
                String branch_id = rs.getString("branch_id");
                int targetValue = rs.getInt("target_value");
                Date startDate = rs.getDate("start_time");
                Date endDate = rs.getDate("deadline");
                String status = rs.getString("sta_tus");

                Sale sale = new Sale(saleId, branch_id, targetValue, startDate, endDate, status);
                saleList.add(sale);
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleList;
    }

    public static Sale selectSaleById(String saleId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        Sale sale = new Sale();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select sale_id from sale where sale_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, saleId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String sale_id = rs.getString("sale_id");
                    sale.setId(sale_id);
                }
            } else {
                sale.setId("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sale;
    }

    public static boolean insertSale(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean saleInserted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO sale VALUES(?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sale.getId());
            st.setString(2, sale.getBranchId());
            st.setInt(3, sale.getTargetValue());
            st.setDate(4, sale.getStartDate());
            st.setDate(5, sale.getEndDate());
            st.setString(6, sale.getStatus());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                saleInserted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleInserted;
    }

    public static boolean updateSaleById(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean saleUpdated = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "update sale"
                    + " set branch_id = ?,"
                    + " target_value = ?,"
                    + " start_time = ?,"
                    + " deadline = ?,"
                    + " sta_tus = ?"
                    + " where sale_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sale.getBranchId());
            st.setInt(2, sale.getTargetValue());
            st.setDate(3, sale.getStartDate());
            st.setDate(4, sale.getEndDate());
            st.setString(5, sale.getStatus());
            st.setString(6, sale.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                saleUpdated = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleUpdated;
    }

    public static boolean deleteSaleById(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        boolean saleDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE FROM sale\n"
                    + "WHERE sale_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, sale.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                saleDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return saleDeleted;
    }
}
