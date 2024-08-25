
package controller;

import dao.AttendanceDAO;
import dao.AttendanceDetailDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Attendance;
import model.AttendanceDetail;
import view.*;
import dao.AttendanceDetailDAO;

public class MaintainAttendanceDetailController {
    public static void loadAttendanceData(MaintainAttendanceDetailScreen view, String id) {
        try {
            List<AttendanceDetail> attendances = AttendanceDetailDAO.getAllAttendanceDetailByAttendanceId(id);
            view.updateAttendanceDetailTable(attendances);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error loading attendance data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static boolean deleteAttendanceDetailByAttendanceId(String empId){
        return AttendanceDetailDAO.deleteAttendanceDetailByAttendanceId(empId);
    }
}
