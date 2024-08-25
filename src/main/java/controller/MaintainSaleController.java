package controller;

import dao.SaleDAO;
import java.util.ArrayList;
import model.Sale;

public class MaintainSaleController {

    public static ArrayList<Sale> selectSaleByBranch(String branchId) {
        return SaleDAO.selectSaleByBranch(branchId);
    }

    public static Sale selectSaleById(String saleId) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return SaleDAO.selectSaleById(saleId);
    }

    public static boolean insertSale(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return SaleDAO.insertSale(sale);
    }

    public static boolean updateSaleById(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return SaleDAO.updateSaleById(sale);
    }

    public static boolean deleteSaleById(Sale sale) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return SaleDAO.deleteSaleById(sale);
    }
}
