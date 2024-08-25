package dao;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import util.JDBCutil;

public class EmployeeDAO {
    private static EmployeeDAO instance;
    
    public static EmployeeDAO gI(){
        if(instance == null){
            instance = new EmployeeDAO();
        }
        return instance;
    }
    
    public HashMap<String, String> getEmployeeIdAndName(){
        HashMap<String, String> employees = new HashMap<>();
        String sql = "SELECT employee_id, full_name FROM EMPLOYEE ";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareCall(sql);
                ResultSet resultset = preparedStatement.executeQuery()){
            while(resultset.next()){
                employees.put(resultset.getString("employee_id"), resultset.getString("full_name"));
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
=======
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Account;
import model.Employee;
import util.JDBCutil;

public class EmployeeDAO {

    public static ArrayList<Employee> selectEmpsByBranch(String branchId) {
        ArrayList<Employee> empList = new ArrayList();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "SELECT employee_id, branch.branch_id, account_id, full_name, date_of_birth, emp_address, employee.email, phone_number, employee_position, gender\n"
                    + "FROM employee INNER JOIN branch ON employee.branch_id = branch.branch_id\n"
                    + "WHERE branch.branch_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, branchId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            while (rs.next()) {
                String empId = rs.getString("employee_id");
                String branch_id = rs.getString("branch_id");
                String accountId = rs.getString("account_id");
                String fullName = rs.getString("full_name");
                Date dateOfBirth = rs.getDate("date_of_birth");
                String empAddress = rs.getString("emp_address");
                String empEmail = rs.getString("email");
                String phoneNumber = rs.getString("phone_number");
                String empPosition = rs.getString("employee_position");
                String empGender = rs.getString("gender");

                Employee emp = new Employee(empId, branchId, accountId, fullName, dateOfBirth, empAddress, empEmail, phoneNumber, empPosition, empGender);
                empList.add(emp);
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empList;
    }

    public static boolean insertEmployee(Employee emp) {
        boolean empInserted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, emp.getId());
            st.setString(2, emp.getBranchId());
            st.setString(3, emp.getAccountId());
            st.setString(4, emp.getFullName());
            st.setDate(5, emp.getDateOfBirth());
            st.setString(6, emp.getAddress());
            st.setString(7, emp.getEmail());
            st.setString(8, emp.getPhoneNumber());
            st.setString(9, emp.getPosition());
            st.setString(10, emp.getGender());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                empInserted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empInserted;
    }
    
    public static boolean deleteEmployeeByAccountId(String accId){
        boolean empDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from employee where account_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, accId);

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                empDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empDeleted;
    }
    
    public static Employee selectEmployeeById(String empId){
        Employee emp = new Employee();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select employee_id from employee where employee_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, empId);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String emp_id = rs.getString("employee_id");
                    emp.setId(emp_id);
                }
            } else {
                emp.setId("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
    
    public static Employee selectEmployeeByEmail(String email){
        Employee emp = new Employee();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select email from employee where email = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, email);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String emp_email = rs.getString("email");
                    emp.setEmail(emp_email);
                }
            } else {
                emp.setEmail("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
    
    public static Employee selectEmployeeByPhoneNo(String phoneNumber){
        Employee emp = new Employee();
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "select phone_number from employee where phone_number = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, phoneNumber);

            // Bước 3: thực thi câu lệnh SQL
            ResultSet rs = st.executeQuery();

            // Bước 4:
            if (rs.isBeforeFirst()) {
                while (rs.next()) {
                    String phone = rs.getString("phone_number");
                    emp.setPhoneNumber(phone);
                }
            } else {
                emp.setPhoneNumber("");
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emp;
    }
    
    public static boolean updateEmployeeById(Employee emp){
        boolean empUpdated = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "update employee"
                    + " set branch_id = ?,"
                    + " account_id = ?,"
                    + " full_name = ?,"
                    + " date_of_birth = ?,"
                    + " emp_address = ?,"
                    + " email = ?,"
                    + " phone_number = ?,"
                    + " employee_position = ?,"
                    + " gender = ?"
                    + " where employee_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, emp.getBranchId());
            st.setString(2, emp.getAccountId());
            st.setString(3, emp.getFullName());
            st.setDate(4, emp.getDateOfBirth());
            st.setString(5, emp.getAddress());
            st.setString(6, emp.getEmail());
            st.setString(7, emp.getPhoneNumber());
            st.setString(8, emp.getPosition());
            st.setString(9, emp.getGender());
            st.setString(10, emp.getId());

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                empUpdated = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empUpdated;
    }
    
    public static boolean deleteEmployeeById(String empId){
        boolean empDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from employee where employee_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, empId);

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                empDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return empDeleted;
>>>>>>> fe132b85f9b069f5bad73c2ec51caf371970f06b
    }
}
