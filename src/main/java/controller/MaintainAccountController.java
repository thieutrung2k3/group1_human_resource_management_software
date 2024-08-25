package controller;

import dao.AccountDAO;
import dao.EmployeeDAO;
import java.util.ArrayList;
import model.Account;

public class MaintainAccountController {

    public static ArrayList<Account> selectAccountsByBranch(String branchId) {
        return AccountDAO.selectAccountsByBranch(branchId);
    }

    public static boolean insertAccount(Account acc) {
        return AccountDAO.insertAccount(acc);
    }

    public static boolean updateAccountById(Account acc) {
        return AccountDAO.updateAccountById(acc);
    }

    public static boolean deleteAccountById(Account acc) {
        //EmployeeDAO.deleteEmployeeByAccountId(acc.getId());
        return AccountDAO.deleteAccountById(acc);
    }

    public static Account selectAccountById(String accId) {
        return AccountDAO.selectAccountById(accId);
    }

    public static Account selectAccountByUserName(String userName) {
        return AccountDAO.selectAccountByUserName(userName);
    }
    
    public static Account selectAccountByEmpId(String empId){
        return AccountDAO.selectAccountByEmpId(empId);
    }

    public static boolean deleteAccountByEmpId(Account acc) {
        return AccountDAO.deleteAccountByEmpId(acc);
    }
}
