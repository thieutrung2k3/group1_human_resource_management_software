/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import dao.BranchDAO;
import dao.EmployeeDAO;
import java.util.List;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.AttendanceDetail;
import model.Branch;
import model.*;
import controller.*;
import dao.AccountDAO;
import javax.swing.JOptionPane;
/**
 *
 * @author PC
 */
public class EmployeeScreen extends javax.swing.JFrame {

    public String empId;
    public Employee employee;
    public Account account;
    public static EmployeeScreen instance;
    public EmployeeScreen(Employee employee, Account account) {
        initComponents();
        this.employee = employee;
        this.account = account;
        init();
    }
    public EmployeeScreen(){
        
    }

    public void init(){
        empId_label.setText(employee.getId());
        empName_label.setText(employee.getFullName());
        empGender_label.setText(employee.getGender());
        empPos_label.setText(employee.getPosition());
        Branch branch = BranchDAO.selectBranchById(employee.getBranchId());
        branchName_label.setText(branch.getName());
        brandAddress_label.setText(branch.getAddress());
        ViewAttendanceHistoryController.loadDataAttendanceTable(this, employee.getId());
        ViewSalaryHistoryController.loadDataSalaryTable(this, employee.getId());
    }
    
    public void updateTableAttendanceHistory(List<AttendanceDetail> attendanceDetails){
        DefaultTableModel attendance_model = (DefaultTableModel) attendance_table.getModel();
        attendance_model.setRowCount(0);
        for(AttendanceDetail a : attendanceDetails){
            Object[] row = {
                a.getCheckInTime(),
                a.getCheckOutTime(),
                a.getStatus(),
                a.getAttendanceDate(),
            };
            attendance_model.addRow(row);
        }
    }
    
    public void updateTableSalaryHistory(List<Salary> salaries){
        DefaultTableModel salary_model = (DefaultTableModel) salary_table.getModel();
        salary_model.setRowCount(0);
        for(Salary s : salaries){
            Object[] row = {
                s.getBaseSalary(),
                s.getAdditionalSalary(),
                s.getDeduction(),
                s.getTotalSalary(),
                s.getPaymentDate()
            };
            salary_model.addRow(row);
        }
    }
    
    public static EmployeeScreen gI(){
        if(instance == null){
            instance = new EmployeeScreen();
        }
        return instance;
    }
    
    public boolean isPasswordFieldBlank(){
        if(currentPassField.getText().isEmpty() || newPassField.getText().isEmpty() || reNewPassField.getText().isEmpty()){
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        empName_label = new javax.swing.JLabel();
        empId_label = new javax.swing.JLabel();
        empPos_label = new javax.swing.JLabel();
        empGender_label = new javax.swing.JLabel();
        branchName_label = new javax.swing.JLabel();
        brandAddress_label = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        attendance_table = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jDateChooser3 = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jDateChooser4 = new com.toedter.calendar.JDateChooser();
        jScrollPane2 = new javax.swing.JScrollPane();
        salary_table = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        currentPassField = new javax.swing.JTextField();
        newPassField = new javax.swing.JTextField();
        reNewPassField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("NHÂN VIÊN");

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPane1.setAutoscrolls(true);
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHÂN VIÊN");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Địa chỉ cơ sở:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Chức vụ:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Giới tính:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Họ tên:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Mã nhân viên:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Cơ sở:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        empName_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empName_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empName_label.setText("employee_name");
        empName_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        empId_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empId_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empId_label.setText("employee_id");
        empId_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        empPos_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empPos_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empPos_label.setText("employee_position");
        empPos_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        empGender_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        empGender_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        empGender_label.setText("employee_gender");
        empGender_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        branchName_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        branchName_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        branchName_label.setText("branch_name");
        branchName_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        brandAddress_label.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        brandAddress_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        brandAddress_label.setText("branch_address");
        brandAddress_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(empId_label)
                            .addComponent(empName_label)
                            .addComponent(empGender_label)
                            .addComponent(empPos_label)
                            .addComponent(branchName_label)
                            .addComponent(brandAddress_label)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(21, 21, 21)))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(empId_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(empName_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(empGender_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(empPos_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(branchName_label))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(brandAddress_label))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("THÔNG TIN NHÂN VIÊN", jPanel1);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("NHÂN VIÊN");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        attendance_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attendance_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Giờ vào", "Giờ ra", "Trạng thái", "Ngày chấm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendance_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(attendance_table);
        if (attendance_table.getColumnModel().getColumnCount() > 0) {
            attendance_table.getColumnModel().getColumn(0).setResizable(false);
            attendance_table.getColumnModel().getColumn(1).setResizable(false);
            attendance_table.getColumnModel().getColumn(2).setResizable(false);
            attendance_table.getColumnModel().getColumn(3).setResizable(false);
        }

        jDateChooser1.setDateFormatString("dd-MM-yyyy");
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("Ngày bắt đầu:");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Ngày kết thúc:");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jDateChooser2.setDateFormatString("dd-MM-yyyy");
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("XEM");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(jLabel14)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("LỊCH SỬ CHẤM CÔNG", jPanel2);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("NHÂN VIÊN");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Ngày bắt đầu:");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jDateChooser3.setDateFormatString("dd-MM-yyyy");
        jDateChooser3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Ngày kết thúc:");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jDateChooser4.setDateFormatString("dd-MM-yyyy");
        jDateChooser4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        salary_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salary_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lương cơ bản", "Lương thêm", "Lương trừ", "Tổng lương", "Ngày chi trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salary_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(salary_table);
        if (salary_table.getColumnModel().getColumnCount() > 0) {
            salary_table.getColumnModel().getColumn(0).setResizable(false);
            salary_table.getColumnModel().getColumn(1).setResizable(false);
            salary_table.getColumnModel().getColumn(2).setResizable(false);
            salary_table.getColumnModel().getColumn(3).setResizable(false);
            salary_table.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("XEM");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel19)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(79, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(jLabel17)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel18)
                    .addComponent(jDateChooser3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(jDateChooser4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 285, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("LỊCH SỬ LƯƠNG", jPanel3);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("NHÂN VIÊN");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel21.setText("Mật khẩu hiện tại:");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Mật khẩu mới:");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Xác nhận:");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        currentPassField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        currentPassField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        newPassField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        newPassField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        reNewPassField.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        reNewPassField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton1.setText("ĐỔI");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addGap(59, 59, 59)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(currentPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(reNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(253, 253, 253)
                        .addComponent(jLabel20)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22)
                    .addComponent(newPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(reNewPassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ĐỔI MẬT KHẨU", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 775, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 431, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("ĐĂNG XUẤT", jPanel5);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 996, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(!isPasswordFieldBlank()){
            String newPass = newPassField.getText();
            String reNewPass = reNewPassField.getText();
            if(newPass.equals(reNewPass)){
                String currentPass = currentPassField.getText();
               // System.out.println(this.account.getPassword() + "-" + currentPass);
                if(this.account.getPassword().equals(currentPass)){
                    this.account.setPassword(newPass);
                    boolean r = AccountDAO.updateAccountById(this.account);
                    if(r){
                        JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thành công!");
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane, "Đổi mật khẩu thất bại!");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(rootPane, "Mật khẩu không chính xác!");
                }
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Mật khẩu mới không trùng khớp!");
            }
            currentPassField.setText("");
            newPassField.setText("");
            reNewPassField.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendance_table;
    private javax.swing.JLabel branchName_label;
    private javax.swing.JLabel brandAddress_label;
    private javax.swing.JTextField currentPassField;
    private javax.swing.JLabel empGender_label;
    private javax.swing.JLabel empId_label;
    private javax.swing.JLabel empName_label;
    private javax.swing.JLabel empPos_label;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private com.toedter.calendar.JDateChooser jDateChooser3;
    private com.toedter.calendar.JDateChooser jDateChooser4;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField newPassField;
    private javax.swing.JTextField reNewPassField;
    private javax.swing.JTable salary_table;
    // End of variables declaration//GEN-END:variables
}
