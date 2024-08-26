/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.SalaryDAO;
import java.util.List;
import model.Salary;
import view.EmployeeScreen;

/**
 *
 * @author PC
 */
public class ViewSalaryHistoryController {
    public static void loadDataSalaryTable(EmployeeScreen view, String id){
        try{
            List<Salary> salaries = SalaryDAO.getAllSalariesByEmpId(id);
            view.updateTableSalaryHistory(salaries);
        }catch(Exception e){
            
        }
    }
}
