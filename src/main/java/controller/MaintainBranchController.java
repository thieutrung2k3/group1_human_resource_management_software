/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BranchDAO;
import java.util.ArrayList;
import java.util.List;
import model.Branch;
import view.AdministratorScreen;

/**
 *
 * @author PC
 */
public class MaintainBranchController {
    
    public static Branch selectBranchById(String branchId){
        return BranchDAO.selectBranchById(branchId);
    }
    public static void loadAllDataBranchTable(AdministratorScreen view){
        List<Branch> braches = BranchDAO.getAllBranches();
        view.updateBranchTable(braches);
    }
}
