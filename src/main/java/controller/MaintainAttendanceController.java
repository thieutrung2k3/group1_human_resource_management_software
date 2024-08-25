/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AttendanceDAO;
<<<<<<< HEAD
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
    
    public MaintainAttendanceController() {
        
    }

    private void initController() {
       
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
=======
import java.util.ArrayList;
import model.Attendance;

/**
 *
 * @author PC
 */
public class MaintainAttendanceController {
    public static ArrayList<Attendance> selectAttendanceByEmpId(String empId){
        return AttendanceDAO.selectAttendanceByEmpId(empId);
    }
    
    public static boolean deleteAttendanceByEmpId(String empId){
        return AttendanceDAO.deleteAttendanceByEmpId(empId);
>>>>>>> fe132b85f9b069f5bad73c2ec51caf371970f06b
    }
}
