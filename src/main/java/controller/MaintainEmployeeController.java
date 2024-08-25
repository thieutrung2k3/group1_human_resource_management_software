/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.EmployeeDAO;
import dao.SalaryDAO;
import java.util.ArrayList;
import model.Account;
import model.Employee;

/**
 *
 * @author PC
 */
public class MaintainEmployeeController {

    public static ArrayList<Employee> selectEmpsByBranch(String branchId) {
        return EmployeeDAO.selectEmpsByBranch(branchId);
    }

    public static boolean insertEmployee(Employee emp) {
        return EmployeeDAO.insertEmployee(emp);
    }

    public static Employee selectEmployeeById(String empId) {
        return EmployeeDAO.selectEmployeeById(empId);
    }

    public static Employee selectEmployeeByEmail(String email) {
        return EmployeeDAO.selectEmployeeByEmail(email);
    }

    public static Employee selectEmployeeByPhoneNo(String phoneNumber) {
        return EmployeeDAO.selectEmployeeByPhoneNo(phoneNumber);
    }

    public static boolean updateEmployeeById(Employee emp) {
        return EmployeeDAO.updateEmployeeById(emp);
    }

    public static boolean deleteEmployeeById(String empId) {
        //MaintainSalaryController.deleteSalaryByEmpId(empId);
        //MaintainAttendanceDetailController.deleteAttendanceDetailByAttendanceId(empId);
        //MaintainAttendanceController.deleteAttendanceByEmpId(empId);
        Account acc = MaintainAccountController.selectAccountByEmpId(empId);
        if (EmployeeDAO.deleteEmployeeById(empId)) {
            MaintainAccountController.deleteAccountByEmpId(acc);
            return true;
        } else {
            return false;
        }
    }
}
