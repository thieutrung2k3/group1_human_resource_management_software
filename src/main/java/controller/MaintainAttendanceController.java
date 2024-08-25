package controller;

import dao.AttendanceDAO;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Attendance;
import view.*;

public class MaintainAttendanceController {
    private MaintenanceScreen view;
    private AttendanceDAO attendanceDAO;
    private static MaintainAttendanceController instance;
    
    public static MaintainAttendanceController gI(){
        if(instance == null){
            instance = new MaintainAttendanceController();
        }
        return instance;
    }
    
    public static List<Attendance> selectAttendanceByEmpId(String empId){
        return AttendanceDAO.selectAttendanceByEmpId(empId);
    }
    public void loadAttendanceData(MaintenanceScreen view) {
        try {
            List<Attendance> attendances = AttendanceDAO.gI().getAllAttendances();
            view.updateAttendanceTable(attendances);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error loading attendance data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void updateAttendanceInformation(MaintenanceScreen view){
        
    }
    
    public boolean deleteAttendance(String id){
        int i = AttendanceDAO.gI().deleteAttendance(id);
        return (i != 0);
    }
    
    public static boolean deleteAttendanceByEmpId(String empId){
        return AttendanceDAO.deleteAttendanceByEmpId(empId);
    }
    
}
