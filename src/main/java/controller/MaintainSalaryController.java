/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.AttendanceDAO;
import dao.SalaryDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import model.Attendance;
import model.Salary;
import view.MaintenanceScreen;
import dao.SalaryDAO;

public class MaintainSalaryController {
    public static void loadSalaryData(MaintenanceScreen view) {
        try {
            List<Salary> salaries = SalaryDAO.getAllSalaries();
            view.updateSalaryTable(salaries);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error loading attendance data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static boolean deleteSalaryByEmpId(String empId){
        return SalaryDAO.deleteSalaryByEmpId(empId);
    }
}
