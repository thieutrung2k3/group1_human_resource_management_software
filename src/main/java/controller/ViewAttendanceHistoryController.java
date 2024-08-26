/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.AttendanceDetail;
import dao.*;
import view.EmployeeScreen;

/**
 *
 * @author PC
 */
public class ViewAttendanceHistoryController {
    public static void loadDataAttendanceTable(EmployeeScreen view, String empId){
        try{
            List<AttendanceDetail> attendanceDetails = new ArrayList<>();
            attendanceDetails = AttendanceDetailDAO.getAllAttendanceDetailByEmployeeId(empId);
            view.updateTableAttendanceHistory(attendanceDetails);
        }catch(Exception e){
            System.out.println("error load data: " + e.getMessage());
        }
    }
}
