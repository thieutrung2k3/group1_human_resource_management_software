package table_model;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Employee;
import model.Sale;

public class SaleTableModel extends AbstractTableModel {

    //fields
    private String headings[] = {"Mã doanh số", "Mã cơ sở", "Chỉ tiêu", "Ngày bắt đầu tính", "Ngày kết thúc tính", "Trạng thái"};
    private Class classes[] = {String.class, String.class, Integer.class, Date.class, Date.class, String.class};
    ArrayList<Sale> saleList = new ArrayList<>();

    //constructors
    public SaleTableModel(ArrayList<Sale> saleList) {
        this.saleList = saleList;
    }

    @Override
    public int getRowCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return saleList.size();
    }

    @Override
    public int getColumnCount() {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        return headings.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        switch (columnIndex) {
            case 0:
                return saleList.get(rowIndex).getId();
            case 1:
                return saleList.get(rowIndex).getBranchId();
            case 2:
                return saleList.get(rowIndex).getTargetValue();
            case 3:
                return saleList.get(rowIndex).getStartDate();
            case 4:
                return saleList.get(rowIndex).getEndDate();
            case 5:
                return saleList.get(rowIndex).getStatus();
            default:
                return null;
        }
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return headings[column];
    }
}
