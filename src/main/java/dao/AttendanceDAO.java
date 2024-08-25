package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.*;
import javax.swing.JOptionPane;
import model.Attendance;
import util.JDBCutil;

public class AttendanceDAO {
    private static AttendanceDAO instance;
    
    public static AttendanceDAO gI(){
        if(instance == null){
            instance = new AttendanceDAO();
        }
        return instance;
    }
    
    public List<Attendance> getAllAttendances() throws SQLException{
        List<Attendance> attendances = new ArrayList<>();
        String sql = "SELECT * FROM ATTENDANCE";
        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery()){
            
            while(resultSet.next()){
                Attendance attendance = new Attendance();
                attendance.setId(resultSet.getString("attendance_id"));
                attendance.setEmpId(resultSet.getString("employee_id"));
                attendance.setCreatedDate(resultSet.getDate("created_date"));
                
                attendances.add(attendance);
            }
        }
        return attendances;
    }
    public int addAttendance(Attendance attendance){
        String sql = "INSERT INTO ATTENDANCE (attendance_id, employee_id, created_date) VALUES\n" +
                        "(?, ?, ?)";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            
            preparedStatement.setString(1, attendance.getId());
            preparedStatement.setString(2, attendance.getEmpId());
            preparedStatement.setString(3, attendance.getCreatedDate().toString());
            
            return preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.out.println("Loi them nvvvvvvvvv: " + ex.getMessage());
        }
        return 0;
    }
    
    public String getAttendanceCountForEmployeeOnDate(String id, String date){
        String sql = "SELECT COUNT(*) FROM ATTENDANCE WHERE employee_id = ? AND created_date = ?";
        String s = "";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareCall(sql)){
            preparedStatement.setString(1, id);
            preparedStatement.setString(2, date);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    int i = resultSet.getInt(1) + 97;
                    char c = (char)i;
                    s = Character.toString(c);
                }
            }
        }catch(SQLException ex){
            System.out.println("error in getAttendanceCountForEmployeeOnDate: " + ex.getMessage());
        }
        return s;
    }
    
    public boolean isDuplicateAttendanceId(String id){
        String sql = "SELECT * FROM ATTENDANCE WHERE attendance_id = ?";
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareCall(sql)){
            preparedStatement.setString(1, id);
            try(ResultSet resultSet = preparedStatement.executeQuery()){
                if(resultSet.next()){
                    return true;
                }
            }
            
        }catch(SQLException ex){
            System.out.println("error in isDuplicateAttendanceId func: " + ex.getMessage());
        }
        return false;
    }
    
    public int updateAttendance(Attendance attendance, String id) {
        String sqlAttendance = "UPDATE ATTENDANCE SET attendance_id = ?, employee_id = ?, created_date = ? WHERE attendance_id = ?";
        int resultAttendance = 0;
        try (Connection connection = JDBCutil.getConnection()) {
            // Tắt chế độ tự động commit để có thể kiểm soát việc commit/rollback
            connection.setAutoCommit(false);

            try (PreparedStatement preparedStatementAttendance = connection.prepareStatement(sqlAttendance);) {

                preparedStatementAttendance.setString(1, attendance.getId());
                preparedStatementAttendance.setString(2, attendance.getEmpId());
                preparedStatementAttendance.setDate(3, new java.sql.Date(attendance.getCreatedDate().getTime()));
                preparedStatementAttendance.setString(4, id);
                resultAttendance = preparedStatementAttendance.executeUpdate();

                connection.commit();

            } catch (SQLException ex) {
                // Nếu có lỗi xảy ra, rollback các thay đổi
                connection.rollback();
                System.out.println("Error in updateAttendance func: " + ex.getMessage());
            }

        } catch (SQLException ex) {
            System.out.println("Error in updateAttendance func: " + ex.getMessage());
        }
        return resultAttendance;
    }
    
    public int deleteAttendance(String id){
        String sql = "DELETE FROM ATTENDANCE WHERE attendance_id = ?";
        int result = 0;
        
        try(Connection connection = JDBCutil.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, id);
            
            result = preparedStatement.executeUpdate();
        }catch(SQLException ex){
            System.out.println("error in deleteAttendance func: " + ex);
        }
        return result;
    }
    

    public boolean hasSingleAttendanceForMonth(String empId, LocalDate date) {
        String sql = "SELECT COUNT(*) FROM ATTENDANCE WHERE employee_id = ? AND MONTH(created_date) = ? AND YEAR(created_date) = ?";
        int month = date.get(ChronoField.MONTH_OF_YEAR);
        int year = date.get(ChronoField.YEAR);

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, empId);
            preparedStatement.setInt(2, month);
            preparedStatement.setInt(3, year);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 1;
                }
            }
        } catch (SQLException ex) {
            System.out.println("Error in hasSingleAttendanceForMonth: " + ex.getMessage());
        }

        return false;
    }


}
