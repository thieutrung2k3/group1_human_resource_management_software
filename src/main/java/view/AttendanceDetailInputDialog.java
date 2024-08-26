/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.Date;
import java.text.SimpleDateFormat;
import util.DateUtils;
import model.*;
import util.*;
import dao.*;
import dao.AttendanceDetailDAO;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class AttendanceDetailInputDialog extends javax.swing.JFrame {

    private String title;
    public String empId;
    public String attendanceId;
    public AttendanceDetailInputDialog(String title, int type) {
        initComponents();
              this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.title = title;
        Init();
    }

    public void Init(){
        titleLabel.setText(title);
        adidField.setEditable(false);
    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        adidField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        timeInFiel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        timeOutField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        dateField = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        titleLabel.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel2.setText("Mã chấm công chi tiết: ");

        adidField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        adidField.setFocusable(false);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel3.setText("Giờ vào: (Nhập theo định dạng: hh:mm:ss)\n");

        timeInFiel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel4.setText("Giờ ra: (Nhập theo định dạng: hh:mm:ss)\n");

        timeOutField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jLabel5.setText("Ngày chấm:");

        dateField.setDateFormatString("dd-MM-yyyy");
        dateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jButton1.setText("Xác nhận");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Get ID");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(adidField)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(timeOutField, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(timeInFiel, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(adidField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeInFiel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(timeOutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dateField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        AttendanceDetail attendanceDetail = new AttendanceDetail();
        attendanceDetail.setId(adidField.getText());
        attendanceDetail.setCheckInTime(TimeUtils.convertStringToSqlTime(timeInFiel.getText()));
        attendanceDetail.setCheckOutTime(TimeUtils.convertStringToSqlTime(timeOutField.getText()));
        attendanceDetail.setAttendanceId(attendanceId);
        java.util.Date selectedDate = dateField.getDate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
        String formattedDate = dateFormat.format(selectedDate);
        attendanceDetail.setAttendanceDate(DateUtils.convertStringToSqlDate(formattedDate));
        attendanceDetail.setStatus(TimeUtils.getAttendanceStatus(attendanceDetail.getCheckInTime()));
        boolean r = AttendanceDetailDAO.addAttendanceDetail(attendanceDetail);
        if(r){
            List<AttendanceDetail> attendanceDetails = AttendanceDetailDAO.getAllAttendanceDetailByAttendanceId(attendanceId);
            MaintenanceScreen.viewDetail.updateAttendanceDetailTable(attendanceDetails);
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "hehe");
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        java.util.Date selectedDate = dateField.getDate(); // Lấy ngày đã chọn
            if (selectedDate != null) {
                
                SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyy"); 
                String formattedDate = dateFormat.format(selectedDate);
                String combinedText = empId + formattedDate;
                adidField.setText(combinedText);
            } else {
                System.out.println("No date selected.");
            }
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField adidField;
    private com.toedter.calendar.JDateChooser dateField;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField timeInFiel;
    private javax.swing.JTextField timeOutField;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
