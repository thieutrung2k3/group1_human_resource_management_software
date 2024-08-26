package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Attendance;
import model.AttendanceDetail;
import util.DateUtils;
import controller.*;
import dao.AttendanceDetailDAO;
import static dao.AttendanceDetailDAO.exportDatabaseToExcel;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class MaintainAttendanceDetailScreen extends javax.swing.JFrame {
    public Attendance attendance;
    public static MaintainAttendanceDetailScreen view;
    public MaintainAttendanceDetailScreen(Attendance attendance) {
        initComponents();
                      this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.attendance = attendance;
        init();
        List<AttendanceDetail> attendanceDetails = AttendanceDetailDAO.getAllAttendanceDetailByAttendanceId(attendance.getId());
        updateAttendanceDetailTable(attendanceDetails);
    }
    
    public void init(){
        attendanceIdLabel.setText("Mã chấm công: " + attendance.getId());
        empLabel.setText("Nhân viên: " + attendance.getEmpId());
        createdDateLabel.setText("Ngày tạo: " + DateUtils.formatDateToString(attendance.getCreatedDate().toLocalDate(), "dd-MM-yyyy"));
    }
    
    public void updateAttendanceDetailTable(List<AttendanceDetail> attendances) {
            DefaultTableModel attendance_model = (DefaultTableModel) attendanceDetailTable.getModel();
            attendance_model.setRowCount(0);
            for (AttendanceDetail attendance : attendances) {
                Object[] row = {
                    attendance.getId(),
                    attendance.getCheckInTime(),
                    attendance.getCheckOutTime(),
                    attendance.getStatus(),
                    attendance.getAttendanceDate()
                };
                attendance_model.addRow(row);
            }
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        attendanceDetailTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        empLabel = new javax.swing.JLabel();
        attendanceIdLabel = new javax.swing.JLabel();
        createdDateLabel = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BẢO TRÌ CT CHẤM CÔNG");

        attendanceDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã chi tiết chấm công", "Giờ vào", "Giờ ra", "Trạng thái", "Ngày chấm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        attendanceDetailTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(attendanceDetailTable);
        if (attendanceDetailTable.getColumnModel().getColumnCount() > 0) {
            attendanceDetailTable.getColumnModel().getColumn(0).setResizable(false);
            attendanceDetailTable.getColumnModel().getColumn(1).setResizable(false);
            attendanceDetailTable.getColumnModel().getColumn(2).setResizable(false);
            attendanceDetailTable.getColumnModel().getColumn(3).setResizable(false);
            attendanceDetailTable.getColumnModel().getColumn(4).setResizable(false);
        }

        jButton1.setText("Xuất Excel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Nhập Excel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton4.setText("Thêm");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton6.setText("Xóa");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        empLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        empLabel.setText("Nhân viên:");

        attendanceIdLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        attendanceIdLabel.setText("Mã chấm công: ");

        createdDateLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        createdDateLabel.setText("Ngày tạo:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(attendanceIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(createdDateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(83, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(empLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(attendanceIdLabel)
                    .addComponent(createdDateLabel))
                .addGap(18, 18, 18)
                .addComponent(empLabel)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(93, 93, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton6)
                            .addComponent(jButton2)
                            .addComponent(jButton1)
                            .addComponent(jButton4))))
                .addContainerGap(340, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(109, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        AttendanceDetailInputDialog vscreen = new AttendanceDetailInputDialog("NHẬP THÔNG TIN", 1);
        vscreen.empId = attendance.getEmpId();
        vscreen.attendanceId = attendance.getId();
        vscreen.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int sr = attendanceDetailTable.getSelectedRow();
        if(sr != -1){
            String id = attendanceDetailTable.getValueAt(sr, 0).toString();
            boolean r = AttendanceDetailDAO.deleteAttendanceDetail(id);
            if(r){
                List<AttendanceDetail> attendanceDetails = AttendanceDetailDAO.getAllAttendanceDetailByAttendanceId(attendance.getId());
                 MaintenanceScreen.viewDetail.updateAttendanceDetailTable(attendanceDetails);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save Excel File");
        fileChooser.setSelectedFile(new File("exported_data.xlsx")); // Đặt tên mặc định cho file

        // Hiển thị hộp thoại lưu file
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());

            // Gọi hàm xuất dữ liệu vào file Excel
            exportDatabaseToExcel(fileToSave.getAbsolutePath(), attendance.getId());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
          fileChooser.setDialogTitle("Select Excel File");

                int userSelection = fileChooser.showOpenDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    File fileToOpen = fileChooser.getSelectedFile();
                    System.out.println("Selected file: " + fileToOpen.getAbsolutePath());

                    // Gọi hàm nhập dữ liệu từ file
                    AttendanceDetailDAO.importDataFromExcel(fileToOpen.getAbsolutePath());
                }
       List<AttendanceDetail> attendanceDetails = AttendanceDetailDAO.getAllAttendanceDetailByAttendanceId(attendance.getId());
            MaintenanceScreen.viewDetail.updateAttendanceDetailTable(attendanceDetails);
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable attendanceDetailTable;
    private javax.swing.JLabel attendanceIdLabel;
    private javax.swing.JLabel createdDateLabel;
    private javax.swing.JLabel empLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
