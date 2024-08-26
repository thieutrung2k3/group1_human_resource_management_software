package view;

import controller.*;
import dao.AttendanceDAO;
import static dao.AttendanceDetailDAO.exportDatabaseToExcel;
import dao.SalaryDAO;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import model.Account;
import model.Attendance;
import model.AttendanceDetail;
import model.Employee;
import model.Salary;
import model.Sale;
import table_model.*;
import util.DateUtils;
import util.*;
import util.JTextFieldUtil;

public class MaintenanceScreen extends javax.swing.JFrame {

    private static MaintenanceScreen instance;
    public static MaintenanceScreen view;
    public MaintainAttendanceDetailScreen detailScreen;
    public static MaintainAttendanceDetailScreen viewDetail;
    public static SalaryCalculationScreen viewSalary;
    private String branchId;

    public MaintenanceScreen() {
        initComponents();
    }

    public MaintenanceScreen(String branchId) {
        this.branchId = branchId;
        initComponents();
                      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.jTextFieldAccId.requestFocus();
        this.jDateChooserEmpDob.getDateEditor().setEnabled(false);
        this.jDateChooserEmpDob.setDate(new Date(new java.util.Date().getTime()));
        this.jComboBoxEmpPosition.setSelectedIndex(0);
        this.jDateChooserStartDate.getDateEditor().setEnabled(false);
        this.jDateChooserEndDate.getDateEditor().setEnabled(false);
        this.jDateChooserStartDate.setDate(new Date(new java.util.Date().getTime()));
        this.jDateChooserEndDate.setDate(new Date(new java.util.Date().getTime()));
        JTextFieldUtil.formatSaleValue(this.jTextFieldSaleValue);
        ButtonGroup btnGroupRole = new ButtonGroup();
        btnGroupRole.add(this.jRadioButtonAdmin);
        btnGroupRole.add(this.jRadioButtonUser);
        this.jRadioButtonUser.setSelected(true);
        ButtonGroup btnGroupGender = new ButtonGroup();
        btnGroupGender.add(this.jRadioButtonGenderNam);
        btnGroupGender.add(this.jRadioButtonGenderNu);
        this.jRadioButtonGenderNam.setSelected(true);
        ButtonGroup btnGroupSaleStatus = new ButtonGroup();
        btnGroupSaleStatus.add(this.jRadioButtonStatusDat);
        btnGroupSaleStatus.add(this.jRadioButtonStatusKhongDat);
        this.jRadioButtonStatusKhongDat.setSelected(true);
        JFrameUtil.centerFrame(this);
        jTableAccountList.setModel(new AccountTableModel(MaintainAccountController.selectAccountsByBranch(this.branchId)));
        jTableEmpList.setModel(new EmployeeTableModel(MaintainEmployeeController.selectEmpsByBranch(this.branchId)));
        jTableSaleList.setModel(new SaleTableModel(MaintainSaleController.selectSaleByBranch(this.branchId)));
        updateEmpInSalary();
        updateAttendanceTable("");
        updateSalaryTable("");
    }

    public static MaintenanceScreen gI() {
        if (instance == null) {
            instance = new MaintenanceScreen();
        }
        return instance;

    }

    public void updateAttendanceTable(String id) {
        DefaultTableModel attendance_model = (DefaultTableModel) attendance_table.getModel();
        List<Attendance> attendances = AttendanceDAO.selectAttendanceByEmpId(id);
        attendance_model.setRowCount(0);
        for (Attendance attendance : attendances) {
            Object[] row = {
                attendance.getId(),
                attendance.getCreatedDate()
            };
            attendance_model.addRow(row);
        }
    }

    public void updateSalaryTable(String id) {
        DefaultTableModel salary_model = (DefaultTableModel) salary_table.getModel();
        List<Salary> salaries = SalaryDAO.getAllSalariesByEmpId(id);
        salary_model.setRowCount(0);
        for (Salary s : salaries) {
            Object[] row = {
                s.getId(),
                s.getBaseSalary(),
                s.getDeduction(),
                s.getAdditionalSalary(),
                s.getTotalSalary(),
                s.getPaymentDate()
            };
            salary_model.addRow(row);
        }
    }

    public void updateEmpInSalary() {
        DefaultTableModel ES_model = (DefaultTableModel) empSalary_table.getModel();
        DefaultTableModel EA_model = (DefaultTableModel) empAttendance_table.getModel();
        List<Employee> employees = MaintainEmployeeController.selectEmpsByBranch(branchId);
        ES_model.setRowCount(0);
        EA_model.setRowCount(0);
        for (Employee e : employees) {
            Object[] row = {
                e.getId() + "-" + e.getFullName()
            };
            ES_model.addRow(row);
            EA_model.addRow(row);
        }
    }

    public String getSelectedRowAttendanceId() {
        int sr = attendance_table.getSelectedRow();
        String id = "";
        if (sr != -1) {
            id = attendance_table.getValueAt(sr, 0).toString();

        }
        return id;
    }
    public String getEmployeeIdInTable(JTable jtable){
        int sr = jtable.getSelectedRow();
        if(sr != -1){
            String line = jtable.getValueAt(sr, 0).toString();
            String[] parts = line.split("-");
            return parts[0];
        }
        return "";
    }
    public boolean isSelectedRowAttendanceTable() {
        int sr = attendance_table.getSelectedRow();
        return (sr != -1);
    }

    public Attendance getSelectedRowAttendance() {
        Attendance attendance = new Attendance();
        int i = attendance_table.getSelectedRow();
        attendance.setId(attendance_table.getValueAt(i, 0).toString());
        attendance.setEmpId(getEmployeeIdInTable(empAttendance_table));
        attendance.setCreatedDate(DateUtils.convertStringToSqlDate(attendance_table.getValueAt(i, 1).toString()));
        return attendance;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneMaintainScreen = new javax.swing.JTabbedPane();
        jPanelMaintainAccount = new javax.swing.JPanel();
        jLabelAdminTitle = new javax.swing.JLabel();
        jLabelAccountId = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelAccessRight = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jTextFieldPassword = new javax.swing.JTextField();
        jRadioButtonAdmin = new javax.swing.JRadioButton();
        jRadioButtonUser = new javax.swing.JRadioButton();
        jButtonAddAccount = new javax.swing.JButton();
        jButtonUpdateAccount = new javax.swing.JButton();
        jButtonDeleteAccount = new javax.swing.JButton();
        jTextFieldAccId = new javax.swing.JTextField();
        jButtonInputNewAccount = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableAccountList = new javax.swing.JTable();
        jPanelMaintainEmployee = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEmpList = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextFieldEmpName = new javax.swing.JTextField();
        jRadioButtonGenderNam = new javax.swing.JRadioButton();
        jRadioButtonGenderNu = new javax.swing.JRadioButton();
        jButtonAddEmp = new javax.swing.JButton();
        jButtonUpdateEmp = new javax.swing.JButton();
        jButtonDelEmp = new javax.swing.JButton();
        jDateChooserEmpDob = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jTextFieldEmpAddress = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextFieldEmpPhoneNo = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jTextFieldEmpEmail = new javax.swing.JTextField();
        jComboBoxEmpPosition = new javax.swing.JComboBox<>();
        jTextFieldEmpId = new javax.swing.JTextField();
        jTextFieldJPanelMaintainEmployeeAccId = new javax.swing.JTextField();
        jTextFieldJPanelMaintainEmployeeBranchId = new javax.swing.JTextField();
        jButtonInputNewEmp = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableSaleList = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jButtonAddSale = new javax.swing.JButton();
        jButtonUpdateSale = new javax.swing.JButton();
        jButtonDeleteSale = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jRadioButtonStatusDat = new javax.swing.JRadioButton();
        jRadioButtonStatusKhongDat = new javax.swing.JRadioButton();
        jDateChooserEndDate = new com.toedter.calendar.JDateChooser();
        jDateChooserStartDate = new com.toedter.calendar.JDateChooser();
        jTextFieldSaleId = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jTextFieldMaintainSaleBranchId = new javax.swing.JTextField();
        jButtonInputNewSale = new javax.swing.JButton();
        jTextFieldSaleValue = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        attendance_table = new javax.swing.JTable();
        jButton13 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        empAttendance_table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        salary_table = new javax.swing.JTable();
        jButton14 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        empSalary_table = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BẢO TRÌ");

        jTabbedPaneMaintainScreen.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPaneMaintainScreen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTabbedPaneMaintainScreen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMaintainScreenMouseClicked(evt);
            }
        });

        jLabelAdminTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabelAdminTitle.setText("QUẢN TRỊ VIÊN");
        jLabelAdminTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelAccountId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAccountId.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAccountId.setText("Mã tài khoản:");
        jLabelAccountId.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelUserName.setText("Tên người dùng:");
        jLabelUserName.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelPassword.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelPassword.setText("Mật khẩu:");
        jLabelPassword.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabelAccessRight.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabelAccessRight.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelAccessRight.setText("Quyền truy cập:");
        jLabelAccessRight.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextFieldPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldPassword.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jRadioButtonAdmin.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonAdmin.setText("Aministrator");
        jRadioButtonAdmin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jRadioButtonUser.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonUser.setText("User");
        jRadioButtonUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonAddAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAddAccount.setText("THÊM");
        jButtonAddAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddAccountActionPerformed(evt);
            }
        });

        jButtonUpdateAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonUpdateAccount.setText("SỬA");
        jButtonUpdateAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUpdateAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateAccountActionPerformed(evt);
            }
        });

        jButtonDeleteAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonDeleteAccount.setText("XÓA");
        jButtonDeleteAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteAccountActionPerformed(evt);
            }
        });

        jTextFieldAccId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldAccId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButtonInputNewAccount.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonInputNewAccount.setText("NHẬP MỚI");
        jButtonInputNewAccount.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonInputNewAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputNewAccountActionPerformed(evt);
            }
        });

        jTableAccountList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableAccountList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã tài khoản", "Tên người dùng", "Mật khẩu", "Quyền truy cập"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableAccountList.getTableHeader().setReorderingAllowed(false);
        jTableAccountList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableAccountListMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTableAccountList);

        javax.swing.GroupLayout jPanelMaintainAccountLayout = new javax.swing.GroupLayout(jPanelMaintainAccount);
        jPanelMaintainAccount.setLayout(jPanelMaintainAccountLayout);
        jPanelMaintainAccountLayout.setHorizontalGroup(
            jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelAccountId)
                            .addComponent(jLabelPassword)
                            .addComponent(jLabelAccessRight)
                            .addComponent(jLabelUserName))
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                                        .addComponent(jRadioButtonAdmin)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonUser))))
                            .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMaintainAccountLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldAccId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(51, 51, 51)
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonUpdateAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonDeleteAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonAddAccount))
                        .addGap(33, 33, 33)
                        .addComponent(jButtonInputNewAccount)
                        .addGap(0, 502, Short.MAX_VALUE))
                    .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6)))
                .addContainerGap())
            .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabelAdminTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMaintainAccountLayout.setVerticalGroup(
            jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelAdminTitle)
                .addGap(11, 11, 11)
                .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAccountId)
                            .addComponent(jTextFieldAccId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelUserName)
                            .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelPassword)
                            .addComponent(jTextFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAccessRight)
                            .addComponent(jRadioButtonAdmin)
                            .addComponent(jRadioButtonUser)))
                    .addGroup(jPanelMaintainAccountLayout.createSequentialGroup()
                        .addGroup(jPanelMaintainAccountLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddAccount)
                            .addComponent(jButtonInputNewAccount))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdateAccount)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteAccount)))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE))
        );

        jTabbedPaneMaintainScreen.addTab("TÀI KHOẢN", jPanelMaintainAccount);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel7.setText("QUẢN TRỊ VIÊN");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableEmpList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableEmpList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableEmpList.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jTableEmpList.setShowGrid(true);
        jTableEmpList.getTableHeader().setReorderingAllowed(false);
        jTableEmpList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableEmpList);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Mã nhân viên:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Họ tên:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Ngày sinh:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Giới tính:");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldEmpName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmpName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jRadioButtonGenderNam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonGenderNam.setText("Nam");
        jRadioButtonGenderNam.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jRadioButtonGenderNu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonGenderNu.setText("Nữ");
        jRadioButtonGenderNu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButtonAddEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAddEmp.setText("THÊM");
        jButtonAddEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddEmpActionPerformed(evt);
            }
        });

        jButtonUpdateEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonUpdateEmp.setText("SỬA");
        jButtonUpdateEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUpdateEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateEmpActionPerformed(evt);
            }
        });

        jButtonDelEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonDelEmp.setText("XÓA");
        jButtonDelEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDelEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDelEmpActionPerformed(evt);
            }
        });

        jDateChooserEmpDob.setDateFormatString("dd-MM-yyyy");
        jDateChooserEmpDob.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Địa chỉ:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldEmpAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmpAddress.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("Email:");
        jLabel14.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("Điện thoại:");
        jLabel16.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldEmpPhoneNo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmpPhoneNo.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("Chức vụ:");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel18.setText("Mã tài khoản:");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel19.setText("Mã cơ sở:");
        jLabel19.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldEmpEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmpEmail.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jComboBoxEmpPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jComboBoxEmpPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân viên bán hàng", "Quản lý" }));

        jTextFieldEmpId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldEmpId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextFieldJPanelMaintainEmployeeAccId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldJPanelMaintainEmployeeAccId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jTextFieldJPanelMaintainEmployeeBranchId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldJPanelMaintainEmployeeBranchId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButtonInputNewEmp.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonInputNewEmp.setText("NHẬP MỚI");
        jButtonInputNewEmp.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonInputNewEmp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputNewEmpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMaintainEmployeeLayout = new javax.swing.GroupLayout(jPanelMaintainEmployee);
        jPanelMaintainEmployee.setLayout(jPanelMaintainEmployeeLayout);
        jPanelMaintainEmployeeLayout.setHorizontalGroup(
            jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(38, 38, 38)
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                .addComponent(jTextFieldEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel14)
                                .addGap(63, 63, 63)
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEmpEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                    .addComponent(jTextFieldEmpPhoneNo)
                                    .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxEmpPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldJPanelMaintainEmployeeAccId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldJPanelMaintainEmployeeBranchId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(2, 2, 2)))
                                .addGap(29, 29, 29)
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonUpdateEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonAddEmp, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButtonDelEmp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                .addComponent(jTextFieldEmpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel19))
                            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserEmpDob, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel16)))
                            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                .addComponent(jRadioButtonGenderNam)
                                .addGap(18, 18, 18)
                                .addComponent(jRadioButtonGenderNu)
                                .addGap(108, 108, 108)
                                .addComponent(jLabel18)))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonInputNewEmp)
                        .addContainerGap(264, Short.MAX_VALUE))))
            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel7)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanelMaintainEmployeeLayout.setVerticalGroup(
            jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jTextFieldEmpEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldEmpId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextFieldEmpName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(jTextFieldEmpPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDateChooserEmpDob, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBoxEmpPosition, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonGenderNam)
                            .addComponent(jRadioButtonGenderNu)
                            .addComponent(jLabel18)
                            .addComponent(jTextFieldJPanelMaintainEmployeeAccId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEmpAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jTextFieldJPanelMaintainEmployeeBranchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10))
                    .addGroup(jPanelMaintainEmployeeLayout.createSequentialGroup()
                        .addGroup(jPanelMaintainEmployeeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddEmp)
                            .addComponent(jButtonInputNewEmp))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdateEmp)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDelEmp)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPaneMaintainScreen.addTab("NHÂN VIÊN", jPanelMaintainEmployee);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel21.setText("QUẢN TRỊ VIÊN");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTableSaleList.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTableSaleList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTableSaleList.getTableHeader().setReorderingAllowed(false);
        jTableSaleList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableSaleListMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableSaleList);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel22.setText("Mã doanh số:");
        jLabel22.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel23.setText("Chỉ tiêu:");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel24.setText("Ngày bắt đầu tính:");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel25.setText("Ngày kết thúc:");
        jLabel25.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButtonAddSale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAddSale.setText("THÊM");
        jButtonAddSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonAddSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddSaleActionPerformed(evt);
            }
        });

        jButtonUpdateSale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonUpdateSale.setText("SỬA");
        jButtonUpdateSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonUpdateSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateSaleActionPerformed(evt);
            }
        });

        jButtonDeleteSale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonDeleteSale.setText("XÓA");
        jButtonDeleteSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonDeleteSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteSaleActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel27.setText("Trạng thái:");
        jLabel27.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jRadioButtonStatusDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonStatusDat.setText("Đạt");
        jRadioButtonStatusDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jRadioButtonStatusKhongDat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jRadioButtonStatusKhongDat.setText("Không đạt");
        jRadioButtonStatusKhongDat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jDateChooserEndDate.setDateFormatString("dd-MM-yyyy");
        jDateChooserEndDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jDateChooserStartDate.setDateFormatString("dd-MM-yyyy");
        jDateChooserStartDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jTextFieldSaleId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldSaleId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel26.setText("Mã cơ sở:");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jTextFieldMaintainSaleBranchId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldMaintainSaleBranchId.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButtonInputNewSale.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonInputNewSale.setText("NHẬP MỚI");
        jButtonInputNewSale.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonInputNewSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInputNewSaleActionPerformed(evt);
            }
        });

        jTextFieldSaleValue.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextFieldSaleValue.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25)
                    .addComponent(jLabel27))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jTextFieldSaleId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel26)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldMaintainSaleBranchId, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel8Layout.createSequentialGroup()
                                        .addComponent(jRadioButtonStatusDat)
                                        .addGap(18, 18, 18)
                                        .addComponent(jRadioButtonStatusKhongDat))
                                    .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jTextFieldSaleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonAddSale, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonUpdateSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteSale, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButtonInputNewSale)
                .addGap(244, 244, 244))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1084, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel21)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel21)
                .addGap(14, 14, 14)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel23)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel24))
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addComponent(jTextFieldSaleId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldSaleValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooserStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jDateChooserEndDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButtonStatusDat)
                            .addComponent(jRadioButtonStatusKhongDat)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonAddSale)
                            .addComponent(jButtonInputNewSale))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUpdateSale)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDeleteSale))
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldMaintainSaleBranchId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel26)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPaneMaintainScreen.addTab("DOANH SỐ", jPanel3);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel28.setText("QUẢN TRỊ VIÊN");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton10.setText("XÓA");
        jButton10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton12.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton12.setText("THÊM");
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        attendance_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attendance_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Mã bảng chấm công", "Ngày tạo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendance_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(attendance_table);
        if (attendance_table.getColumnModel().getColumnCount() > 0) {
            attendance_table.getColumnModel().getColumn(0).setResizable(false);
            attendance_table.getColumnModel().getColumn(1).setResizable(false);
        }

        jButton13.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton13.setText("CHI TIẾT");
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        empAttendance_table.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        empAttendance_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empAttendance_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empAttendance_tableMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(empAttendance_table);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 942, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton13))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(400, 400, 400)
                        .addComponent(jLabel28)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10)
                    .addComponent(jButton13))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneMaintainScreen.addTab("CHẤM CÔNG", jPanel4);

        jLabel29.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel29.setText("QUẢN TRỊ VIÊN");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        salary_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        salary_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã lương", "Lương cơ bản", "Lương trừ", "Lương thêm", "Tổng lương", "Ngày chi trả"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        salary_table.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(salary_table);
        if (salary_table.getColumnModel().getColumnCount() > 0) {
            salary_table.getColumnModel().getColumn(0).setResizable(false);
            salary_table.getColumnModel().getColumn(1).setResizable(false);
            salary_table.getColumnModel().getColumn(2).setResizable(false);
            salary_table.getColumnModel().getColumn(3).setResizable(false);
            salary_table.getColumnModel().getColumn(4).setResizable(false);
            salary_table.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton14.setText("XUẤT EXCEL");
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton16.setText("TÍNH LƯƠNG");
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        empSalary_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nhân viên"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        empSalary_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                empSalary_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(empSalary_table);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 5, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 937, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(400, 400, 400)
                                .addComponent(jLabel29))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jButton14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton16)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel29)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton14)
                    .addComponent(jButton16))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE))
                .addContainerGap())
        );

        jTabbedPaneMaintainScreen.addTab("LƯƠNG", jPanel5);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jTabbedPaneMaintainScreen.addTab("QUAY VỀ", jPanel7);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1166, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 502, Short.MAX_VALUE)
        );

        jTabbedPaneMaintainScreen.addTab("ĐĂNG XUẤT", jPanel9);

        jTabbedPaneMaintainScreen.setSelectedComponent(jPanelMaintainAccount);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMaintainScreen)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneMaintainScreen)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        int sr = empSalary_table.getSelectedRow();
        if(sr != -1){
            viewSalary = new SalaryCalculationScreen(this, getEmployeeIdInTable(empSalary_table));
        viewSalary.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng.");
        }
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed

        if (isSelectedRowAttendanceTable()) {
            Attendance attendance = getSelectedRowAttendance();
            viewDetail = new MaintainAttendanceDetailScreen(attendance);
            viewDetail.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng!!");
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (!isSelectedRowAttendanceTable()) {
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng!!");
        } else {
            int op = JOptionPane.showConfirmDialog(rootPane, "Xác nhận xóa.");
            if(op == JOptionPane.YES_OPTION){
                boolean i = MaintainAttendanceController.gI().deleteAttendance(getSelectedRowAttendanceId());
                if (!i) {
                    JOptionPane.showMessageDialog(rootPane, "error");
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Xóa thành công.");
                }
                updateAttendanceTable(getEmployeeIdInTable(empAttendance_table));
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    //event handling methods
    private void jButtonDelEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDelEmpActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableEmpList)) {
            return;
        }

        String empId = this.jTextFieldEmpId.getText();

        int result = JOptionPane.showConfirmDialog(null, "Delete this employee will also delete his/her:\n"
                + "1. Account\n"
                + "2. Attendance\n"
                + "3. Attendance details\n"
                + "4. Salary", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (MaintainEmployeeController.deleteEmployeeById(empId)) {
                JOptionPane.showMessageDialog(null, "Employee deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.jTableEmpList.setModel(new EmployeeTableModel(MaintainEmployeeController.selectEmpsByBranch(this.branchId)));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Người dùng chọn No
        }
    }//GEN-LAST:event_jButtonDelEmpActionPerformed

    private void jButtonDeleteAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteAccountActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableAccountList)) {
            return;
        }

        String accId = this.jTextFieldAccId.getText();
        String userName = this.jTextFieldUserName.getText();
        String password = this.jTextFieldPassword.getText();
        String accessRight;
        if (this.jRadioButtonAdmin.isSelected()) {
            accessRight = "Admin";
        } else {
            accessRight = this.jRadioButtonUser.getText();
        }

        Account acc = new Account(accId, userName, password, accessRight);

        int result = JOptionPane.showConfirmDialog(null, "Deleting this account will also delete:\n"
                + "1. The employee who is its owner\n"
                + "2. His/her attendance\n"
                + "3. His/her attendance detail\n"
                + "4. His/her salary", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (MaintainAccountController.deleteAccountById(acc)) {
                JOptionPane.showMessageDialog(null, "Account deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.jTableAccountList.setModel(new AccountTableModel(MaintainAccountController.selectAccountsByBranch(this.branchId)));
            } else {
                JOptionPane.showMessageDialog(null, "Account not deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Người dùng chọn No
        }
    }//GEN-LAST:event_jButtonDeleteAccountActionPerformed

    private void jTabbedPaneMaintainScreenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMaintainScreenMouseClicked
        // TODO add your handling code here:
        if (this.jTabbedPaneMaintainScreen.getSelectedIndex() == 0) {
            this.jTableAccountList.setModel(new AccountTableModel(MaintainAccountController.selectAccountsByBranch(this.branchId)));
        } else if (this.jTabbedPaneMaintainScreen.getSelectedIndex() == 1) {
            jTableEmpList.setModel(new EmployeeTableModel(MaintainEmployeeController.selectEmpsByBranch(this.branchId)));
        } else if (this.jTabbedPaneMaintainScreen.getSelectedIndex() == 2) {
            jTableSaleList.setModel(new SaleTableModel(MaintainSaleController.selectSaleByBranch(this.branchId)));
        }else if (this.jTabbedPaneMaintainScreen.getSelectedIndex() == 5) {
            new AdministratorScreen().setVisible(true);
            dispose();
        }else if (this.jTabbedPaneMaintainScreen.getSelectedIndex() == 6) {
            int op = JOptionPane.showConfirmDialog(rootPane, "Bạn có muốn thoát?");
            if(op == JOptionPane.YES_OPTION){
                new LoginScreen().setVisible(true);
                dispose();
            }else{
                this.jTabbedPaneMaintainScreen.setSelectedIndex(0);
            }
        }

    }//GEN-LAST:event_jTabbedPaneMaintainScreenMouseClicked


    private void jButtonAddAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddAccountActionPerformed
        // TODO add your handling code here:
        if (isAccInfoEmpty()) {
            return;
        } else if (JTextFieldUtil.isAccIdExisted(this.jTextFieldAccId)) {
            return;
        } else if (JTextFieldUtil.isUserNameExisted(this.jTextFieldUserName)) {
            return;
        }

        String accId = this.jTextFieldAccId.getText();
        String userName = this.jTextFieldUserName.getText();
        String password = this.jTextFieldPassword.getText();
        String accessRight;
        if (this.jRadioButtonAdmin.isSelected()) {
            accessRight = "Admin";
        } else {
            accessRight = this.jRadioButtonUser.getText();
        }

        Account acc = new Account(accId, userName, password, accessRight);

        if (MaintainAccountController.insertAccount(acc)) {
            JOptionPane.showMessageDialog(null, "Account inserted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.jTableAccountList.setModel(new AccountTableModel(MaintainAccountController.selectAccountsByBranch(this.branchId)));
        } else {
            JOptionPane.showMessageDialog(null, "Account not inserted!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddAccountActionPerformed

    private void jButtonUpdateAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateAccountActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableAccountList)) {
            return;
        } else if (JTextFieldUtil.isUserNameExisted(this.jTextFieldUserName)) {
            return;
        }

        String accId = this.jTextFieldAccId.getText();
        String userName = this.jTextFieldUserName.getText();
        String password = this.jTextFieldPassword.getText();
        String accessRight;
        if (this.jRadioButtonAdmin.isSelected()) {
            accessRight = "Admin";
        } else {
            accessRight = this.jRadioButtonUser.getText();
        }

        Account acc = new Account(accId, userName, password, accessRight);

        int result = JOptionPane.showConfirmDialog(null, "Update this account", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (MaintainAccountController.updateAccountById(acc)) {
                JOptionPane.showMessageDialog(null, "Account updated successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.jTableAccountList.setModel(new AccountTableModel(MaintainAccountController.selectAccountsByBranch(this.branchId)));
            } else {
                JOptionPane.showMessageDialog(null, "Account not updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Người dùng chọn No
        }
    }//GEN-LAST:event_jButtonUpdateAccountActionPerformed

    private void jButtonAddEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddEmpActionPerformed
        // TODO add your handling code here:
        if (isEmpInfoEmpty()) {
            return;
        } else if (JTextFieldUtil.isEmpIdExisted(this.jTextFieldEmpId)) {
            return;
        } else if (JTextFieldUtil.isEmpEmailExisted(this.jTextFieldEmpEmail)) {
            return;
        } else if (JTextFieldUtil.isPhoneNumberExisted(this.jTextFieldEmpPhoneNo)) {
            return;
        } else if (JTextFieldUtil.isAccNotExisted(this.jTextFieldJPanelMaintainEmployeeAccId)) {
            return;
        } else if (JTextFieldUtil.isBranchNotExisted(this.jTextFieldJPanelMaintainEmployeeBranchId)) {
            return;
        }

        String empId = this.jTextFieldEmpId.getText();
        String branch_id = this.jTextFieldJPanelMaintainEmployeeBranchId.getText();
        String accountId = this.jTextFieldJPanelMaintainEmployeeAccId.getText();
        String fullName = this.jTextFieldEmpName.getText();
        Date dateOfBirth = new Date(this.jDateChooserEmpDob.getDate().getTime());
        String empAddress = this.jTextFieldEmpAddress.getText();
        String empEmail = this.jTextFieldEmpEmail.getText();
        String phoneNumber = this.jTextFieldEmpPhoneNo.getText();
        String empPosition = (String) this.jComboBoxEmpPosition.getSelectedItem();
        String empGender;
        if (this.jRadioButtonGenderNam.isSelected()) {
            empGender = this.jRadioButtonGenderNam.getText();
        } else {
            empGender = this.jRadioButtonGenderNu.getText();
        }

        Employee emp = new Employee(empId, branch_id, accountId, fullName, dateOfBirth, empAddress, empEmail, phoneNumber, empPosition, empGender);
        if (MaintainEmployeeController.insertEmployee(emp)) {
            JOptionPane.showMessageDialog(null, "Employee inserted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.jTableEmpList.setModel(new EmployeeTableModel(MaintainEmployeeController.selectEmpsByBranch(this.branchId)));
        } else {
            JOptionPane.showMessageDialog(null, "Employee not inserted!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddEmpActionPerformed

    private void jButtonInputNewAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputNewAccountActionPerformed
        // TODO add your handling code here:
        this.jTextFieldAccId.setText("");
        this.jTextFieldUserName.setText("");
        this.jTextFieldPassword.setText("");
        this.jRadioButtonUser.setSelected(true);
        this.jRadioButtonAdmin.setSelected(false);
        this.jTextFieldAccId.setEditable(true);
        this.jTextFieldAccId.requestFocus();
    }//GEN-LAST:event_jButtonInputNewAccountActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int sr = empAttendance_table.getSelectedRow();
        if(sr != -1){
            String empId = getEmployeeIdInTable(empAttendance_table);
            InputDialog inputDialog = new InputDialog("NHẬP THÔNG TIN CHẤM CÔNG", empId, this);
            inputDialog.setVisible(true);
            inputDialog.settingTextField(true, false);
        }else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng.");
        }
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        int sr = empSalary_table.getSelectedRow();
        if(sr != -1){
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Save Excel File");
            fileChooser.setSelectedFile(new File("exported_data.xlsx")); // Đặt tên mặc định cho file
            List<Salary> salaries = SalaryDAO.getAllSalariesByEmpId(getEmployeeIdInTable(empSalary_table));
            // Hiển thị hộp thoại lưu file
            int userSelection = fileChooser.showSaveDialog(null);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                File fileToSave = fileChooser.getSelectedFile();
                System.out.println("Save as file: " + fileToSave.getAbsolutePath());
                JOptionPane.showMessageDialog(rootPane, "Save as file: " + fileToSave.getAbsolutePath());
                // Gọi hàm xuất dữ liệu vào file Excel
                SalaryDAO.exportSalariesToExcel(salaries, fileToSave.getAbsolutePath());
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng!");
        }
    }//GEN-LAST:event_jButton14ActionPerformed


    private void jButtonUpdateEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateEmpActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableEmpList)) {
            return;
        } else if (isEmpInfoEmpty()) {
            return;
        } else if (JTextFieldUtil.isEmpEmailExisted(this.jTextFieldEmpEmail)) {
            return;
        } else if (JTextFieldUtil.isPhoneNumberExisted(this.jTextFieldEmpEmail)) {
            return;
        } else if (JTextFieldUtil.isAccNotExisted(this.jTextFieldJPanelMaintainEmployeeAccId)) {
            return;
        } else if (JTextFieldUtil.isBranchNotExisted(this.jTextFieldJPanelMaintainEmployeeBranchId)) {
            return;
        }

        String empId = this.jTextFieldEmpId.getText();
        String branch_id = this.jTextFieldJPanelMaintainEmployeeBranchId.getText();
        String accountId = this.jTextFieldJPanelMaintainEmployeeAccId.getText();
        String fullName = this.jTextFieldEmpName.getText();
        Date dateOfBirth = new Date(this.jDateChooserEmpDob.getDate().getTime());
        String empAddress = this.jTextFieldEmpAddress.getText();
        String empEmail = this.jTextFieldEmpEmail.getText();
        String phoneNumber = this.jTextFieldEmpPhoneNo.getText();
        String empPosition = (String) this.jComboBoxEmpPosition.getSelectedItem();
        String empGender;
        if (this.jRadioButtonGenderNam.isSelected()) {
            empGender = this.jRadioButtonGenderNam.getText();
        } else {
            empGender = this.jRadioButtonGenderNu.getText();
        }

        Employee emp = new Employee(empId, branch_id, accountId, fullName, dateOfBirth, empAddress, empEmail, phoneNumber, empPosition, empGender);

        int result = JOptionPane.showConfirmDialog(null, "Update this employee?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (MaintainEmployeeController.updateEmployeeById(emp)) {
                JOptionPane.showMessageDialog(null, "Employee updated successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.jTableEmpList.setModel(new EmployeeTableModel(MaintainEmployeeController.selectEmpsByBranch(this.branchId)));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Người dùng chọn No
        }
    }//GEN-LAST:event_jButtonUpdateEmpActionPerformed

    private void jTableEmpListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpListMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = this.jTableEmpList.getSelectedRow();
        if (selectedRowIndex != -1) {
            String empId = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 0);
            String branch_id = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 1);
            String accId = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 2);
            String empName = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 3);
            Date empDob = (Date) this.jTableEmpList.getValueAt(selectedRowIndex, 4);
            String empAddress = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 5);
            String empEmail = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 6);
            String empPhoneNumber = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 7);
            String empPosition = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 8);
            String empGender = (String) this.jTableEmpList.getValueAt(selectedRowIndex, 9);

            this.jTextFieldEmpId.setText(empId);
            this.jTextFieldEmpId.setEditable(false);
            this.jTextFieldEmpName.setText(empName);
            this.jDateChooserEmpDob.setDate(empDob);
            if (empGender.equals(this.jRadioButtonGenderNam.getText())) {
                this.jRadioButtonGenderNam.setSelected(true);
            } else {
                this.jRadioButtonGenderNu.setSelected(true);
            }
            this.jTextFieldEmpAddress.setText(empAddress);
            this.jTextFieldEmpEmail.setText(empEmail);
            this.jTextFieldEmpPhoneNo.setText(empPhoneNumber);
            this.jComboBoxEmpPosition.setSelectedItem(empPosition);
            this.jTextFieldJPanelMaintainEmployeeAccId.setText(accId);
            this.jTextFieldJPanelMaintainEmployeeBranchId.setText(branch_id);
        }
    }//GEN-LAST:event_jTableEmpListMouseClicked

    private void jButtonInputNewEmpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputNewEmpActionPerformed
        // TODO add your handling code here:
        this.jTextFieldEmpId.setEditable(true);
        this.jTextFieldEmpId.setText("");
        this.jTextFieldEmpName.setText("");
        this.jDateChooserEmpDob.setDate(new Date(new java.util.Date().getTime()));
        this.jTextFieldEmpAddress.setText("");
        this.jTextFieldEmpEmail.setText("");
        this.jTextFieldEmpPhoneNo.setText("");
        this.jComboBoxEmpPosition.setSelectedIndex(0);
        this.jTextFieldJPanelMaintainEmployeeAccId.setText("");
        this.jTextFieldJPanelMaintainEmployeeBranchId.setText("");
    }//GEN-LAST:event_jButtonInputNewEmpActionPerformed

    private void jButtonDeleteSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteSaleActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableSaleList)) {
            return;
        }

        String saleId = this.jTextFieldSaleId.getText();
        Sale sale = new Sale();
        sale.setId(saleId);

        int result = JOptionPane.showConfirmDialog(null, "Delete this sale?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (result == JOptionPane.YES_OPTION) {
            if (MaintainSaleController.deleteSaleById(sale)) {
                JOptionPane.showMessageDialog(null, "Sale deleted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
                this.jTableSaleList.setModel(new SaleTableModel(MaintainSaleController.selectSaleByBranch(this.branchId)));
            } else {
                JOptionPane.showMessageDialog(null, "Employee not deleted!", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            // Người dùng chọn No
        }
    }//GEN-LAST:event_jButtonDeleteSaleActionPerformed

    private void jTableSaleListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableSaleListMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = this.jTableSaleList.getSelectedRow();
        if (selectedRowIndex != -1) {
            String saleId = (String) this.jTableSaleList.getValueAt(selectedRowIndex, 0);
            String branch_id = (String) this.jTableSaleList.getValueAt(selectedRowIndex, 1);
            String targetValue = this.jTableSaleList.getValueAt(selectedRowIndex, 2).toString();
            Date startDate = (Date) this.jTableSaleList.getValueAt(selectedRowIndex, 3);
            Date endDate = (Date) this.jTableSaleList.getValueAt(selectedRowIndex, 4);
            String status = (String) this.jTableSaleList.getValueAt(selectedRowIndex, 5);

            this.jTextFieldSaleId.setText(saleId);
            this.jTextFieldSaleId.setEditable(false);
            this.jTextFieldMaintainSaleBranchId.setText(branch_id);
            this.jTextFieldSaleValue.setText(targetValue);
            this.jDateChooserStartDate.setDate(startDate);
            this.jDateChooserEndDate.setDate(endDate);
            if (status.equals(this.jRadioButtonStatusDat.getText())) {
                this.jRadioButtonStatusDat.setSelected(true);
            } else {
                this.jRadioButtonStatusKhongDat.setSelected(false);
            }
        }
    }//GEN-LAST:event_jTableSaleListMouseClicked

    private void jButtonInputNewSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInputNewSaleActionPerformed
        // TODO add your handling code here:
        this.jTextFieldSaleId.setEditable(true);
        this.jTextFieldSaleId.setText("");
        this.jTextFieldMaintainSaleBranchId.setText("");
        this.jTextFieldSaleValue.setText("");
        this.jDateChooserStartDate.setDate(new Date(new java.util.Date().getTime()));
        this.jDateChooserEndDate.setDate(new Date(new java.util.Date().getTime()));
        this.jRadioButtonStatusKhongDat.setSelected(true);
    }//GEN-LAST:event_jButtonInputNewSaleActionPerformed

    private void jButtonAddSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddSaleActionPerformed
        // TODO add your handling code here:
        if (isSaleInfoEmpty()) {
            return;
        } else if (JTextFieldUtil.isSaleIdExisted(this.jTextFieldSaleId)) {
            return;
        } else if (JTextFieldUtil.isBranchNotExisted(this.jTextFieldMaintainSaleBranchId)) {
            return;
        }

        String saleId = this.jTextFieldSaleId.getText();
        String branch_id = this.jTextFieldMaintainSaleBranchId.getText();
        int saleValue = Integer.valueOf(this.jTextFieldSaleValue.getText()).intValue();
        Date startDate = new Date(this.jDateChooserStartDate.getDate().getTime());
        Date endDate = new Date(this.jDateChooserEndDate.getDate().getTime());
        String status = "";
        if (this.jRadioButtonStatusDat.isSelected()) {
            status = this.jRadioButtonStatusDat.getText();
        } else {
            status = this.jRadioButtonStatusKhongDat.getText();
        }

        Sale sale = new Sale(saleId, branch_id, saleValue, startDate, endDate, status);

        if (MaintainSaleController.insertSale(sale)) {
            JOptionPane.showMessageDialog(null, "Sale inserted successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.jTableSaleList.setModel(new SaleTableModel(MaintainSaleController.selectSaleByBranch(this.branchId)));
        } else {
            JOptionPane.showMessageDialog(null, "Sale not inserted!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonAddSaleActionPerformed

    private void jButtonUpdateSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateSaleActionPerformed
        // TODO add your handling code here:
        if (!JTableUtil.isARowSelected(this.jTableSaleList)) {
            return;
        } else if (isSaleInfoEmpty()) {
            return;
        } else if (JTextFieldUtil.isBranchNotExisted(this.jTextFieldMaintainSaleBranchId)) {
            return;
        }

        String saleId = this.jTextFieldSaleId.getText();
        String branch_id = this.jTextFieldMaintainSaleBranchId.getText();
        int saleValue = Integer.valueOf(this.jTextFieldSaleValue.getText()).intValue();
        Date startDate = new Date(this.jDateChooserStartDate.getDate().getTime());
        Date endDate = new Date(this.jDateChooserEndDate.getDate().getTime());
        String status = "";
        if (this.jRadioButtonStatusDat.isSelected()) {
            status = this.jRadioButtonStatusDat.getText();
        } else {
            status = this.jRadioButtonStatusKhongDat.getText();
        }

        Sale sale = new Sale(saleId, branch_id, saleValue, startDate, endDate, status);

        if (MaintainSaleController.updateSaleById(sale)) {
            JOptionPane.showMessageDialog(null, "Sale updated successfully!", "Information", JOptionPane.INFORMATION_MESSAGE);
            this.jTableSaleList.setModel(new SaleTableModel(MaintainSaleController.selectSaleByBranch(this.branchId)));
        } else {
            JOptionPane.showMessageDialog(null, "Sale not updated!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonUpdateSaleActionPerformed

    private void empSalary_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empSalary_tableMouseClicked
        int sr = empSalary_table.getSelectedRow();
        String line = empSalary_table.getValueAt(sr, 0).toString();
        String[] parts = line.split("-");
        String id = parts[0];
        updateSalaryTable(id);
    }//GEN-LAST:event_empSalary_tableMouseClicked

    private void empAttendance_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_empAttendance_tableMouseClicked
        int sr = empAttendance_table.getSelectedRow();
        String line = empAttendance_table.getValueAt(sr, 0).toString();
        String[] parts = line.split("-");
        String id = parts[0];
        updateAttendanceTable(id);
    }//GEN-LAST:event_empAttendance_tableMouseClicked

    private void jTableAccountListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableAccountListMouseClicked
        // TODO add your handling code here:
        int selectedRowIndex = this.jTableAccountList.getSelectedRow();
        if (selectedRowIndex != -1) {
            String accId = (String) this.jTableAccountList.getValueAt(selectedRowIndex, 0);
            String userName = (String) this.jTableAccountList.getValueAt(selectedRowIndex, 1);
            String password = (String) this.jTableAccountList.getValueAt(selectedRowIndex, 2);
            String accessRight = (String) this.jTableAccountList.getValueAt(selectedRowIndex, 3);

            this.jTextFieldAccId.setEditable(false);
            this.jTextFieldAccId.setText(accId);
            this.jTextFieldUserName.setText(userName);
            this.jTextFieldPassword.setText(password);
            if (accessRight.equals(this.jRadioButtonAdmin.getText())) {
                this.jRadioButtonAdmin.setSelected(true);
            } else {
                this.jRadioButtonUser.setSelected(true);
            }
        }
    }//GEN-LAST:event_jTableAccountListMouseClicked

    //utility methods
    private boolean isAccInfoEmpty() {
        boolean isEmpty = false;

        if (this.jTextFieldAccId.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Account id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldUserName.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "User name is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldPassword.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Password is required", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return isEmpty;
    }

    private boolean isEmpInfoEmpty() {
        boolean isEmpty = false;

        if (this.jTextFieldEmpId.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldEmpName.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee name is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jDateChooserEmpDob.getDate() == null) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee date of birth is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldEmpAddress.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee address is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldEmpEmail.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee email is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldEmpPhoneNo.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Employee phone number is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldJPanelMaintainEmployeeAccId.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Account id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldJPanelMaintainEmployeeBranchId.getText().equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Branch id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }

        return isEmpty;
    }

    private boolean isSaleInfoEmpty() {
        boolean isEmpty = false;
        if (this.jTextFieldSaleId.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Sale id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldSaleValue.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Sale value is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else if (this.jTextFieldMaintainSaleBranchId.getText().trim().replaceAll("\\s+", "").equals("")) {
            isEmpty = true;
            JOptionPane.showMessageDialog(null, "Branch id is required!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return isEmpty;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendance_table;
    private javax.swing.JTable empAttendance_table;
    private javax.swing.JTable empSalary_table;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButtonAddAccount;
    private javax.swing.JButton jButtonAddEmp;
    private javax.swing.JButton jButtonAddSale;
    private javax.swing.JButton jButtonDelEmp;
    private javax.swing.JButton jButtonDeleteAccount;
    private javax.swing.JButton jButtonDeleteSale;
    private javax.swing.JButton jButtonInputNewAccount;
    private javax.swing.JButton jButtonInputNewEmp;
    private javax.swing.JButton jButtonInputNewSale;
    private javax.swing.JButton jButtonUpdateAccount;
    private javax.swing.JButton jButtonUpdateEmp;
    private javax.swing.JButton jButtonUpdateSale;
    private javax.swing.JComboBox<String> jComboBoxEmpPosition;
    private com.toedter.calendar.JDateChooser jDateChooserEmpDob;
    private com.toedter.calendar.JDateChooser jDateChooserEndDate;
    private com.toedter.calendar.JDateChooser jDateChooserStartDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAccessRight;
    private javax.swing.JLabel jLabelAccountId;
    private javax.swing.JLabel jLabelAdminTitle;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel jPanelMaintainAccount;
    private javax.swing.JPanel jPanelMaintainEmployee;
    private javax.swing.JRadioButton jRadioButtonAdmin;
    private javax.swing.JRadioButton jRadioButtonGenderNam;
    private javax.swing.JRadioButton jRadioButtonGenderNu;
    private javax.swing.JRadioButton jRadioButtonStatusDat;
    private javax.swing.JRadioButton jRadioButtonStatusKhongDat;
    private javax.swing.JRadioButton jRadioButtonUser;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPaneMaintainScreen;
    private javax.swing.JTable jTableAccountList;
    private javax.swing.JTable jTableEmpList;
    private javax.swing.JTable jTableSaleList;
    private javax.swing.JTextField jTextFieldAccId;
    private javax.swing.JTextField jTextFieldEmpAddress;
    private javax.swing.JTextField jTextFieldEmpEmail;
    private javax.swing.JTextField jTextFieldEmpId;
    private javax.swing.JTextField jTextFieldEmpName;
    private javax.swing.JTextField jTextFieldEmpPhoneNo;
    private javax.swing.JTextField jTextFieldJPanelMaintainEmployeeAccId;
    private javax.swing.JTextField jTextFieldJPanelMaintainEmployeeBranchId;
    private javax.swing.JTextField jTextFieldMaintainSaleBranchId;
    private javax.swing.JTextField jTextFieldPassword;
    private javax.swing.JTextField jTextFieldSaleId;
    private javax.swing.JTextField jTextFieldSaleValue;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JTable salary_table;
    // End of variables declaration//GEN-END:variables
}
