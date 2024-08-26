package dao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Salary;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.regex.REUtil;
import util.JDBCutil;

public class SalaryDAO {
    
    public static List<Salary> getAllSalariesByEmpId(String empId){
        String sql = "SELECT * FROM SALARY WHERE employee_id = ?";
        List<Salary> salaries = new ArrayList<>();
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, empId);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                while(resultSet.next()){
                    Salary salary = new Salary();
                    salary.setId(resultSet.getString("salary_id"));
                    salary.setEmpId(resultSet.getString("employee_id"));
                    salary.setBaseSalary((int)resultSet.getDouble("base_salary"));
                    salary.setAdditionalSalary((int)resultSet.getDouble("additional_salary"));
                    salary.setDeduction((int)resultSet.getDouble("deduction"));
                    salary.setTotalSalary((int)resultSet.getDouble("total_salary"));
                    salary.setPaymentDate(resultSet.getDate("payment_date"));
                    salaries.add(salary);
                }
            }
        }catch(SQLException e){
            System.out.println("error in getAllSalariesByEmpId: " + e);
        }
        return salaries;
    }
    public static boolean addSalary(Salary salary) {
        String sql = "INSERT INTO SALARY (salary_id, employee_id, base_salary, additional_salary, deduction, total_salary, payment_date) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Thiết lập các tham số cho PreparedStatement
            preparedStatement.setString(1, salary.getId());
            preparedStatement.setString(2, salary.getEmpId());
            preparedStatement.setDouble(3, salary.getBaseSalary());
            preparedStatement.setDouble(4, salary.getAdditionalSalary());
            preparedStatement.setDouble(5, salary.getDeduction());
            preparedStatement.setDouble(6, salary.getTotalSalary());
            preparedStatement.setDate(7, new Date(salary.getPaymentDate().getTime()));

            // Thực thi lệnh chèn dữ liệu
            int rowsAffected = preparedStatement.executeUpdate();

            // Kiểm tra xem có bao nhiêu hàng bị ảnh hưởng bởi lệnh chèn
            return rowsAffected > 0;

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            return false;
        }
    }
   public static List<Salary> getAllSalaries() {
        List<Salary> salaries = new ArrayList<>();
        String sql = "SELECT * FROM SALARY";

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                // Đọc dữ liệu từ ResultSet
                String salaryId = resultSet.getString("salary_id");
                String employeeId = resultSet.getString("employee_id");
                
                // Chuyển đổi từ double sang int
                int baseSalary = (int) resultSet.getDouble("base_salary");
                int additionalSalary = (int) resultSet.getDouble("additional_salary");
                int deduction = (int) resultSet.getDouble("deduction");
                int totalSalary = (int) resultSet.getDouble("total_salary");
                Date paymentDate = resultSet.getDate("payment_date");

                // Tạo đối tượng Salary từ dữ liệu
                Salary salary = new Salary(salaryId, employeeId, baseSalary, additionalSalary, deduction, totalSalary, paymentDate);
                salaries.add(salary);
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }

        return salaries;
    }
   public static void exportSalariesToExcel(List<Salary> salaries, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Salaries Data");

            // Tạo tiêu đề cột
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Salary ID");
            headerRow.createCell(1).setCellValue("Employee ID");
            headerRow.createCell(2).setCellValue("Base Salary");
            headerRow.createCell(3).setCellValue("Additional Salary");
            headerRow.createCell(4).setCellValue("Deduction");
            headerRow.createCell(5).setCellValue("Total Salary");
            headerRow.createCell(6).setCellValue("Payment Date");

            // Điền dữ liệu vào bảng
            int rowNum = 1;
            for (Salary salary : salaries) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(salary.getId());
                row.createCell(1).setCellValue(salary.getEmpId());
                row.createCell(2).setCellValue(salary.getBaseSalary());
                row.createCell(3).setCellValue(salary.getAdditionalSalary());
                row.createCell(4).setCellValue(salary.getDeduction());
                row.createCell(5).setCellValue(salary.getTotalSalary());
                row.createCell(6).setCellValue(salary.getPaymentDate().toString());
            }

            // Ghi dữ liệu vào file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
            }

        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
   }
    public static boolean deleteSalaryByEmpId(String empId) {
        boolean salDeleted = false;
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from SALARY where employee_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, empId);

            // Bước 3: thực thi câu lệnh SQL
            int affectedRowNumber = st.executeUpdate();

            // Bước 4: xử lý kết quả nhận được
            if (affectedRowNumber > 0) {
                salDeleted = true;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salDeleted;
    }
}
