package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import util.JDBCutil;

public class AccountDAO {
    
    public static ArrayList<Account> selectAccountsByBranch(String branchId) {
        ArrayList<Account> accList = new ArrayList();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT a_ccount.account_id, username, pass_word, access_right\n"
                    + "FROM branch INNER JOIN employee ON branch.branch_id = employee.branch_id\n"
                    + "INNER JOIN a_ccount ON a_ccount.account_id = employee.account_id\n"
                    + "WHERE branch.branch_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, branchId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String accountId = rs.getString("account_id");
                String userName = rs.getString("username");
                String password = rs.getString("pass_word");
                String accessRight = rs.getString("access_right");
                
                Account acc = new Account(accountId, userName, password, accessRight);
                accList.add(acc);
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accList;
    }
    
    public static boolean insertAccount(Account acc) {
        boolean accInserted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO a_ccount VALUES(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, acc.getId());
            st.setString(2, acc.getUserName());
            st.setString(3, acc.getPassword());
            st.setString(4, acc.getAccessRight());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                accInserted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accInserted;
    }
    
    public static boolean updateAccountById(Account acc) {
        boolean accUpdated = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "UPDATE a_ccount\n"
                    + "SET username = ?,"
                    + "pass_word = ?,"
                    + "access_right = ?\n"
                    + "WHERE account_id = ?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, acc.getUserName());
            st.setString(2, acc.getPassword());
            st.setString(3, acc.getAccessRight());
            st.setString(4, acc.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                accUpdated = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accUpdated;
    }
    
    public static boolean deleteAccountById(Account acc) {
        boolean accDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "DELETE FROM a_ccount\n"
                    + "WHERE account_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, acc.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                accDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accDeleted;
    }
    
    public static Account selectAccountById(String accId) {
        Account acc = new Account();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select account_id"
                    + " from a_ccount"
                    + " where account_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, accId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String accountId = rs.getString("account_id");
                    acc.setId(accountId);
                }
            } else {
                acc.setId("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    public static Account selectAccountByUserName(String userName) {
        Account acc = new Account();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select username"
                    + " from a_ccount"
                    + " where username = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, userName);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String user_name = rs.getString("username");
                    acc.setUserName(user_name);
                }
            } else {
                acc.setUserName("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
    
    public static boolean deleteAccountByEmpId(Account acc) {
        boolean accDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from a_ccount where account_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, acc.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                accDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accDeleted;
    }
    
    public static Account selectAccountByEmpId(String empId) {
        Account acc = new Account();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select a_ccount.account_id"
                    + " from a_ccount inner join employee"
                    + " on a_ccount.account_id = employee.account_id"
                    + " where employee_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, empId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String accountId = rs.getString("account_id");
                acc.setId(accountId);
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return acc;
    }
}
