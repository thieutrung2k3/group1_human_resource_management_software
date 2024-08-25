package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import model.Attendance;
import util.JDBCutil;

public class AttendanceDetailDAO {

    public static boolean deleteAttendanceDetailByAttendanceId(String empId) {
        boolean detailDeleted = false;
        ArrayList<Attendance> attList = AttendanceDAO.selectAttendanceByEmpId(empId);
        try {
            // Bước 1: tạo kết nối đến CSDL
            Connection con = JDBCutil.getConnection();

            // Bước 2: tạo ra đối tượng statement
            String sql = "delete from attendance_detail where attendance_id = ?;";
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
