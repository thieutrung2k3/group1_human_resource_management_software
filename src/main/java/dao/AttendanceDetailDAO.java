package dao;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Attendance;
import model.AttendanceDetail;
import util.DateUtils;
import util.JDBCutil;
import util.TimeUtils;


public class AttendanceDetailDAO {
    
    public static List<AttendanceDetail> getAllAttendanceDetailByEmployeeId(String empId) {
    List<AttendanceDetail> attendanceDetails = new ArrayList<>();
    String sql = "SELECT * "
            + "FROM ATTENDANCE "
            + "INNER JOIN ATTENDANCE_DETAIL ON ATTENDANCE.attendance_id = ATTENDANCE_DETAIL.attendance_id "
            + "WHERE ATTENDANCE.employee_id = ?";

    try (Connection connection = JDBCutil.getConnection();
         PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

        // Thiết lập giá trị tham số cho PreparedStatement
        preparedStatement.setString(1, empId);

        // Thực thi truy vấn
        try (ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                AttendanceDetail attendanceDetail = new AttendanceDetail();
                attendanceDetail.setId(resultSet.getString("attendance_detail_id"));
                attendanceDetail.setAttendanceId(resultSet.getString("attendance_id")); 

                // Kiểm tra giá trị "check_in_time" có bị null không trước khi chuyển đổi
                String checkInTimeStr = resultSet.getString("check_in_time");
                if (checkInTimeStr != null) {
                    attendanceDetail.setCheckInTime(TimeUtils.convertStringToSqlTime(checkInTimeStr));
                } else {
                    attendanceDetail.setCheckInTime(null); 
                }

                // Kiểm tra giá trị "check_out_time" có bị null không trước khi chuyển đổi
                String checkOutTimeStr = resultSet.getString("check_out_time");
                if (checkOutTimeStr != null) {
                    attendanceDetail.setCheckOutTime(TimeUtils.convertStringToSqlTime(checkOutTimeStr));
                } else {
                    attendanceDetail.setCheckOutTime(null); 
                }

                // Kiểm tra giá trị "attendance_date" có bị null không trước khi chuyển đổi
                String attendanceDateStr = resultSet.getString("attendance_date");
                if (attendanceDateStr != null) {
                    attendanceDetail.setAttendanceDate(DateUtils.convertStringToSqlDate(attendanceDateStr));
                } else {
                    attendanceDetail.setAttendanceDate(null); 
                }

                // Kiểm tra trạng thái dựa trên check-in time
                attendanceDetail.setStatus(TimeUtils.getAttendanceStatus(attendanceDetail.getCheckInTime()));

                attendanceDetails.add(attendanceDetail); // Thêm vào danh sách kết quả
            }
        }
    } catch (SQLException e) {
        System.out.println("SQL Exception: " + e.getMessage()); // Cải thiện thông báo lỗi
    }

    return attendanceDetails;
}

    public static List<AttendanceDetail> getAllAttendanceDetailByAttendanceId(String id) {
        List<AttendanceDetail> attendanceDetails = new ArrayList<>();
        String sql = "SELECT * FROM ATTENDANCE_DETAIL WHERE attendance_id = ?"; // Sử dụng dấu ? để sử dụng PreparedStatement

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Thiết lập giá trị tham số cho PreparedStatement
            preparedStatement.setString(1, id);

            // Thực thi truy vấn
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    AttendanceDetail attendanceDetail = new AttendanceDetail();
                    attendanceDetail.setId(resultSet.getString("attendance_detail_id"));
                    attendanceDetail.setAttendanceId(id); // Đã có giá trị từ tham số hàm

                    // Kiểm tra giá trị "check_in_time" có bị null không trước khi chuyển đổi
                    String checkInTimeStr = resultSet.getString("check_in_time");
                    if (checkInTimeStr != null) {
                        attendanceDetail.setCheckInTime(TimeUtils.convertStringToSqlTime(checkInTimeStr));
                    } else {
                        attendanceDetail.setCheckInTime(null); // Đặt giá trị null nếu không có dữ liệu
                    }

                    // Kiểm tra giá trị "check_out_time" có bị null không trước khi chuyển đổi
                    String checkOutTimeStr = resultSet.getString("check_out_time");
                    if (checkOutTimeStr != null) {
                        attendanceDetail.setCheckOutTime(TimeUtils.convertStringToSqlTime(checkOutTimeStr));
                    } else {
                        attendanceDetail.setCheckOutTime(null); // Đặt giá trị null nếu không có dữ liệu
                    }

                    // Kiểm tra giá trị "attendance_date" có bị null không trước khi chuyển đổi
                    String attendanceDateStr = resultSet.getString("attendance_date");
                    if (attendanceDateStr != null) {
                        attendanceDetail.setAttendanceDate(DateUtils.convertStringToSqlDate(attendanceDateStr));
                    } else {
                        attendanceDetail.setAttendanceDate(null); // Đặt giá trị null nếu không có dữ liệu
                    }

                    // Kiểm tra trạng thái dựa trên check-in time
                    attendanceDetail.setStatus(TimeUtils.getAttendanceStatus(attendanceDetail.getCheckInTime()));

                    attendanceDetails.add(attendanceDetail); // Thêm vào danh sách kết quả
                }
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage()); // Cải thiện thông báo lỗi
        }

    return attendanceDetails;
}
    public static boolean addAttendanceDetail(AttendanceDetail attendanceDetail) {
        String sql = "INSERT INTO ATTENDANCE_DETAIL (attendance_detail_id, attendance_id, check_in_time, check_out_time, attendance_date, sta_tus) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Thiết lập giá trị tham số cho PreparedStatement
            preparedStatement.setString(1, attendanceDetail.getId());
            preparedStatement.setString(2, attendanceDetail.getAttendanceId());

            if (attendanceDetail.getCheckInTime() != null) {
                preparedStatement.setTime(3, attendanceDetail.getCheckInTime());
            } else {
                preparedStatement.setNull(3, java.sql.Types.TIME);
            }

            if (attendanceDetail.getCheckOutTime() != null) {
                preparedStatement.setTime(4, attendanceDetail.getCheckOutTime());
            } else {
                preparedStatement.setNull(4, java.sql.Types.TIME);
            }

            if (attendanceDetail.getAttendanceDate() != null) {
                preparedStatement.setDate(5, attendanceDetail.getAttendanceDate());
            } else {
                preparedStatement.setNull(5, java.sql.Types.DATE);
            }

            if (attendanceDetail.getStatus() != null) {
                preparedStatement.setString(6, attendanceDetail.getStatus());
            } else {
                preparedStatement.setNull(6, java.sql.Types.VARCHAR);
            }

            // Thực thi câu lệnh INSERT
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
            return false; // Trả về false nếu có lỗi xảy ra
        }
}
    public static boolean deleteAttendanceDetail(String attendanceDetailId) {
        String sql = "DELETE FROM ATTENDANCE_DETAIL WHERE attendance_detail_id = ?";

        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Thiết lập giá trị tham số cho PreparedStatement
            preparedStatement.setString(1, attendanceDetailId);

            // Thực thi câu lệnh DELETE
            int rowsAffected = preparedStatement.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu có ít nhất một dòng bị ảnh hưởng
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage()); // Cải thiện thông báo lỗi
            return false; // Trả về false nếu có lỗi xảy ra
        }
}


    
    public static void exportDatabaseToExcel(String filePath, String id) {
        // Sử dụng PreparedStatement để bảo vệ khỏi SQL Injection
        String sql = "SELECT * FROM ATTENDANCE_DETAIL WHERE attendance_id = ?";
        
        try (Connection connection = JDBCutil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            // Thiết lập giá trị tham số cho PreparedStatement
            preparedStatement.setString(1, id);

            // Thực thi truy vấn
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                Workbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Attendance Data");

                // Tạo tiêu đề cột
                Row headerRow = sheet.createRow(0);
                headerRow.createCell(0).setCellValue("attendance_detail_id");
                headerRow.createCell(1).setCellValue("attendance_id");
                headerRow.createCell(2).setCellValue("check_in_time");
                headerRow.createCell(3).setCellValue("check_out_time");
                headerRow.createCell(4).setCellValue("attendance_date");
                headerRow.createCell(5).setCellValue("sta_tus");

                // Thêm dữ liệu vào các hàng tiếp theo
                int rowNum = 1;
                while (resultSet.next()) {
                    Row row = sheet.createRow(rowNum++);
                    row.createCell(0).setCellValue(resultSet.getString("attendance_detail_id"));
                    row.createCell(1).setCellValue(resultSet.getString("attendance_id"));
                    row.createCell(2).setCellValue(resultSet.getString("check_in_time"));
                    row.createCell(3).setCellValue(resultSet.getString("check_out_time"));
                    row.createCell(4).setCellValue(resultSet.getString("attendance_date"));
                    row.createCell(5).setCellValue(resultSet.getString("sta_tus"));
                }

                // Lưu Workbook vào file
                try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                    workbook.write(fileOut);
                } catch (IOException e) {
                    System.out.println("Error writing to file: " + e.getMessage());
                } finally {
                    workbook.close();
                }
            }
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IO Exception: " + ex.getMessage());
        }
    }
    public static void importDataFromExcel(String filePath) {
        String sql = "INSERT INTO ATTENDANCE_DETAIL (attendance_detail_id, attendance_id, check_in_time, check_out_time, attendance_date, sta_tus) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0); // Lấy sheet đầu tiên
            Connection connection = JDBCutil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            // Bỏ qua hàng tiêu đề
            boolean firstRow = true;
            for (Row row : sheet) {
                if (firstRow) {
                    firstRow = false;
                    continue; // Bỏ qua hàng tiêu đề
                }

                // Đọc dữ liệu từ hàng
                String detailId = row.getCell(0).getStringCellValue();
                String attendanceId = row.getCell(1).getStringCellValue();
                String checkInTime = row.getCell(2).getStringCellValue();
                String checkOutTime = row.getCell(3).getStringCellValue();
                String attendanceDate = row.getCell(4).getStringCellValue();
                String status = row.getCell(5).getStringCellValue();

                // Thiết lập các tham số cho PreparedStatement
                preparedStatement.setString(1, detailId);
                preparedStatement.setString(2, attendanceId);
                preparedStatement.setString(3, checkInTime);
                preparedStatement.setString(4, checkOutTime);
                preparedStatement.setString(5, attendanceDate);
                preparedStatement.setString(6, status);

                // Thực thi lệnh chèn dữ liệu
                preparedStatement.executeUpdate();
            }

            // Đóng kết nối
            connection.close();

        } catch (IOException e) {
            System.out.println("Error reading Excel file: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        }
    }
    public static boolean deleteAttendanceDetailByAttendanceId(String empId) {
        boolean detailDeleted = false;
        ArrayList<Attendance> attList = AttendanceDAO.selectAttendanceByEmpId(empId);
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from ATTENDANCE_DETAIL where attendance_id = ?;";
            PreparedStatement st = con.prepareStatement(sql);
            for (Attendance att : attList) {
                st.setString(1, att.getId());
                // Bước 3: thực thi câu lệnh SQL
                int affectedRowNumber = st.executeUpdate();
                // Bước 4: xử lý kết quả nhận được
                if (affectedRowNumber > 0) {
                    detailDeleted = true;
                } else {
                    return detailDeleted;
                }
                detailDeleted = false;
            }

            // Bước 5: đóng kết nối
            JDBCutil.closeConnection(con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return detailDeleted;
    }
}
