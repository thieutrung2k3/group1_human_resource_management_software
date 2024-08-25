/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AttendanceDAO;
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
    }
}
