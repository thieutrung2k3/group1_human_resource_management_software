package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Account;
import model.Branch;
import org.apache.xmlbeans.impl.regex.REUtil;
import util.JDBCutil;

public class BranchDAO {

    public static List<Branch> getAllBranches(){
        List<Branch> branches = new ArrayList<>();
        String sql = "SELECT * FROM BRANCH";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                ResultSet resultSet = preparedStatement.executeQuery()){
            while(resultSet.next()){
                Branch branch = new Branch();
                branch.setId(resultSet.getString("branch_id"));
                branch.setName(resultSet.getString("branch_name"));
                branch.setAddress(resultSet.getString("branch_address"));
                branch.setHotline(resultSet.getString("hotline"));
                branch.setEmail(resultSet.getString("email"));
                branches.add(branch);
            }
        }catch(SQLException e){
            System.out.println("error in getAllBranches func: " + e.getMessage());
        }
        return branches;
    }
    
    public static List<Branch> getAllBranchesById(String id){
        List<Branch> branches = new ArrayList<>();
        String sql = "SELECT * FROM BRANCH WHERE branch_id = ?";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);   
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                    while(resultSet.next()){
                        Branch branch = new Branch();
                        branch.setId(id);
                        branch.setName(resultSet.getString("branch_name"));
                        branch.setAddress(resultSet.getString("branch_address"));
                        branch.setHotline(resultSet.getString("hotline"));
                        branch.setEmail(resultSet.getString("email"));
                        branches.add(branch);
                }
                }
        }catch(SQLException e){
            System.out.println("error in getAllBranches func: " + e.getMessage());
        }
        return branches;
    }
    
    public static boolean updateBranch(Branch branch){
        String sql = "UPDATE BRANCH SET branch_name = ?, branch_address = ?, hotline = ?, email = ? "
               + "WHERE branch_id = ?";
        int r = 0;
        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement pre = connection.prepareStatement(sql)) {

            pre.setString(1, branch.getName());
            pre.setString(2, branch.getAddress());
            pre.setString(3, branch.getHotline());
            pre.setString(4, branch.getEmail());
            pre.setString(5, branch.getId());

            r = pre.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in updateBranch: " + e.getMessage());
        }
        return r > 0;
    }
    
    public static boolean deleteBranch(String id){
        String sql = "DELETE FROM BRANCH WHERE branch_id = ?";
        int r = 0;
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement pre = connection.prepareStatement(sql)){
            pre.setString(1, id);
            r = pre.executeUpdate();
        }catch(SQLException e){
            System.out.println("error in delete branch: " + e.getMessage());
        }
        return r > 0;
    }
    
    public static boolean addBranch(Branch branch){
         String sql = "INSERT INTO BRANCH (branch_id, branch_name, branch_address, hotline, email)"
                 + " VALUES (?, ?, ?, ?, ?)";
         int r = 0;
         try(Connection connection = JDBCutil.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)){
             preparedStatement.setString(1, branch.getId());
             preparedStatement.setString(2, branch.getName());
             preparedStatement.setString(3, branch.getAddress());
             preparedStatement.setString(4, branch.getHotline());
             preparedStatement.setString(5, branch.getEmail());
             
             r = preparedStatement.executeUpdate();
             
         }catch(SQLException e){
             System.out.println("error in addBranch: " + e.getMessage());
         }
         return (r > 0);
    }
    
    public static Branch selectBranchById(String branchId) {
        Branch branch = new Branch();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select *"
                    + " from BRANCH"
                    + " where branch_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, branchId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String branch_id = rs.getString("branch_id");
                    branch.setId(branch_id);
                    branch.setName(rs.getString("branch_name"));
                    branch.setAddress(rs.getString("branch_address"));
                }
            } else {
                branch.setId("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return branch;
    }
}
