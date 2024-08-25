/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AttendanceDetailDAO;

/**
 *
 * @author PC
 */
public class MaintainAttendanceDetailController {
    public static boolean deleteAttendanceDetailByAttendanceId(String empId){
        return AttendanceDetailDAO.deleteAttendanceDetailByAttendanceId(empId);
    }
}
