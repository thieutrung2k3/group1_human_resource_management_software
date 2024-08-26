package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Account;
import util.JDBCutil;

public class AccountDAO {
    public static boolean isAccountExist(Account account){
        String sql = "SELECT * FROM A_CCOUNT WHERE username = ? AND pass_word = ?";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, account.getUserName());
            preparedStatement.setString(2, account.getPassword());
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    account.setId(resultSet.getString("account_id"));
                    account.setAccessRight(resultSet.getString("access_right"));
                    return true;
                }
            }
        }catch(SQLException e){
            System.out.println("error in isAccountExist func: " + e.getMessage());
            return false;
        }
        return false;
    }
    
   
    
    public static ArrayList<Account> selectAccountsByBranch(String branchId) {
        ArrayList<Account> accList = new ArrayList();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT A_CCOUNT.account_id, username, pass_word, access_right\n"
                    + "FROM BRANCH INNER JOIN EMPLOYEE ON BRANCH.branch_id = EMPLOYEE.branch_id\n"
                    + "INNER JOIN A_CCOUNT ON A_CCOUNT.account_id = EMPLOYEE.account_id\n"
                    + "WHERE BRANCH.branch_id = ?;";
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
            String sql = "INSERT INTO A_CCOUNT VALUES(?,?,?,?)";
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
            String sql = "UPDATE A_CCOUNT\n"
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
            String sql = "DELETE FROM A_CCOUNT\n"
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
                    + " from A_CCOUNT"
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
                    + " from A_CCOUNT"
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
            String sql = "delete from A_CCOUNT where account_id = ?;";
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
            String sql = "select A_CCOUNT.account_id"
                    + " from A_CCOUNT inner join EMPLOYEE"
                    + " on A_CCOUNT.account_id = EMPLOYEE.account_id"
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
