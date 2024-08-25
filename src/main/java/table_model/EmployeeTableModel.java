package table_model;

import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Employee;

public class EmployeeTableModel extends AbstractTableModel {

    //fields
    private String headings[] = {"Mã nhân viên", "Mã cơ sở", "Mã tài khoản", "Họ tên", "Ngày sinh", "Địa chỉ", "Email", "Điện thoại", "Chức vụ", "Giới tính"};
    private Class classes[] = {String.class, String.class, String.class, String.class, Date.class, String.class, String.class, String.class, String.class, String.class};
    ArrayList<Employee> empList = new ArrayList<>();

    //constructors
    public EmployeeTableModel(ArrayList<Employee> empList) {
        this.empList = empList;
    }

    //lấy số phần tử của accList
    @Override
    public int getRowCount() {
        return empList.size();
    }

    //Lấy số lượng tiêu để của mảng
    @Override
    public int getColumnCount() {
        return headings.length;
    }

    //Đưa thông tin của phần tử trong arrayList lên jTable
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return empList.get(rowIndex).getId();
            case 1:
                return empList.get(rowIndex).getBranchId();
            case 2:
                return empList.get(rowIndex).getAccountId();
            case 3:
                return empList.get(rowIndex).getFullName();
            case 4:
                return empList.get(rowIndex).getDateOfBirth();
            case 5:
                return empList.get(rowIndex).getAddress();
            case 6:
                return empList.get(rowIndex).getEmail();
            case 7:
                return empList.get(rowIndex).getPhoneNumber();
            case 8:
                return empList.get(rowIndex).getPosition();
            case 9:
                return empList.get(rowIndex).getGender();
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
