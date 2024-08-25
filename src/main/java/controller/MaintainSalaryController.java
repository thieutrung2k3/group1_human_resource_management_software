/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SalaryDAO;

/**
 *
 * @author PC
 */
public class MaintainSalaryController {
    public static boolean deleteSalaryByEmpId(String empId){
        return SalaryDAO.deleteSalaryByEmpId(empId);
    }
}
