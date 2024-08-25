package table_model;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Account;

public class AccountTableModel extends AbstractTableModel {

    //fields
    private String headings[] = {"Mã tài khoản", "Tên người dùng", "Mật khẩu", "Quyền truy cập"};
    private Class classes[] = {String.class, String.class, String.class, String.class};
    ArrayList<Account> accList = new ArrayList<>();

    //constructors
    public AccountTableModel(ArrayList<Account> accList) {
        this.accList = accList;
    }

    //lấy số phần tử của accList
    public int getRowCount() {
        return accList.size();
    }

    //Lấy số lượng tiêu để của mảng
    public int getColumnCount() {
        return headings.length;
    }

    //Đưa thông tin của phần tử trong arrayList lên jTable
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {

            case 0:
                return accList.get(rowIndex).getId();

            case 1:
                return accList.get(rowIndex).getUserName();

            case 2:
                return accList.get(rowIndex).getPassword();
            case 3:
                return accList.get(rowIndex).getAccessRight();
            default:
                return null;
        }
    }

    public Class getColumnClass(int columnIndex) {
        return classes[columnIndex];
    }

    public String getColumnName(int column) {
        return headings[column];
    }
}
