/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.BranchDAO;
import model.Branch;

/**
 *
 * @author PC
 */
public class MaintainBranchController {
    
    public static Branch selectBranchById(String branchId){
        return BranchDAO.selectBranchById(branchId);
    }
}
