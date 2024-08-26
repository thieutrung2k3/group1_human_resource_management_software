package view;

import controller.MaintainBranchController;
import dao.BranchDAO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Branch;

public class AdministratorScreen extends javax.swing.JFrame {

    private static AdministratorScreen instance;
    private MaintenanceScreen view;
    public AdministratorScreen() {
        initComponents();
        MaintainBranchController.loadAllDataBranchTable(this);
    }

    public static AdministratorScreen gI(){
        if(instance == null){
            instance = new AdministratorScreen();
        }
        return instance;
    }
    
    public void updateBranchTable(List<Branch> branches){
        DefaultTableModel branch_model = (DefaultTableModel) branch_table.getModel();
        branch_model.setRowCount(0);
        for(Branch branch : branches){
            Object[] row = {
                branch.getId(),
                branch.getName(),
                branch.getAddress(),
                branch.getHotline(),
                branch.getEmail()
            };
            branch_model.addRow(row);
        }
    }
    
    public boolean isFieldEmpty(){
        if(id_field.getText().isEmpty() || name_field.getText().isEmpty() || address_field.getText().isEmpty() 
                ||email_field.getText().isEmpty() || phone_field.getText().isEmpty()){
            return true;
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel28 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        findField = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        name_field = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        phone_field = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        branch_table = new javax.swing.JTable();
        address_field = new javax.swing.JTextField();
        email_field = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        id_field = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUẢN TRỊ VIÊN");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel28.setText("QUẢN TRỊ VIÊN");
        jLabel28.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Mã cơ sở:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        findField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        findField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        findField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findFieldActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton4.setText("THÊM");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Tên cơ sở:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        name_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        name_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton5.setText("SỬA");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Địa chỉ:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("Email:");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jButton6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton6.setText("XÓA");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("Điện thoại:");
        jLabel13.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        phone_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        phone_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        branch_table.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        branch_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã cơ sở", "Tên cơ sở", "Địa chỉ", "Hotline", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        branch_table.getTableHeader().setReorderingAllowed(false);
        branch_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                branch_tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(branch_table);
        if (branch_table.getColumnModel().getColumnCount() > 0) {
            branch_table.getColumnModel().getColumn(0).setResizable(false);
            branch_table.getColumnModel().getColumn(1).setResizable(false);
            branch_table.getColumnModel().getColumn(2).setResizable(false);
            branch_table.getColumnModel().getColumn(3).setResizable(false);
            branch_table.getColumnModel().getColumn(4).setResizable(false);
        }

        address_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        address_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        email_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        email_field.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButton7.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton7.setText("TÌM KIẾM");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jButton8.setText("TRUY CẬP");
        jButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        id_field.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(name_field, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(address_field, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(email_field, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(phone_field, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(id_field))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(61, 61, 61)
                        .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 134, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel28)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(findField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton7)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton5)
                            .addComponent(jButton8))
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(id_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(name_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(email_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(phone_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel13)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int sr = branch_table.getSelectedRow();
        if(sr != -1){
            String id = branch_table.getValueAt(sr, 0).toString();
            boolean r = BranchDAO.deleteBranch(id);
            if(r){
                MaintainBranchController.loadAllDataBranchTable(this);
                JOptionPane.showMessageDialog(rootPane, "Xóa thành công!");
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Xóa không thành công!");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng.");
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(!isFieldEmpty()){
            Branch branch = new Branch();
            branch.setId(id_field.getText());
            branch.setName(name_field.getText());
            branch.setAddress(address_field.getText());
            branch.setEmail(email_field.getText());
            branch.setHotline(phone_field.getText());
            boolean r = BranchDAO.addBranch(branch);
            if(r){
                JOptionPane.showMessageDialog(rootPane, "Thêm thành công!");
                MaintainBranchController.loadAllDataBranchTable(this);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Thêm thất bại!");
            }
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng điền đầy đủ thông tin.");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        int sr = branch_table.getSelectedRow();
        if(sr != -1){
            String id = branch_table.getValueAt(sr, 0).toString();
            view = new MaintenanceScreen(id);
            view.setVisible(true);
            dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng.");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int sr = branch_table.getSelectedRow();
        if(isFieldEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng nhập đầy đủ thông tin.");
            
        }
        else if(sr == -1){
            JOptionPane.showMessageDialog(rootPane, "Vui lòng chọn 1 dòng.");
        }
        else{
            String id = id_field.getText();
            String name = name_field.getText();
            String address = address_field.getText();
            String hotline = phone_field.getText();
            String email = email_field.getText();
            
            Branch branch = new Branch(id, name, address, hotline, email);
            
            boolean r = BranchDAO.updateBranch(branch);
            if(r){
                
                JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công.");
                MaintainBranchController.loadAllDataBranchTable(this);
            }
            else{
                JOptionPane.showMessageDialog(rootPane, "Lỗi cập nhật.");
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void branch_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_branch_tableMouseClicked
        int sr = branch_table.getSelectedRow();
        if(sr != -1){
            String id = branch_table.getValueAt(sr, 0).toString();
            String name = branch_table.getValueAt(sr, 1).toString();
            String address = branch_table.getValueAt(sr, 2).toString();
            String hotline = branch_table.getValueAt(sr, 3).toString();
            String email = branch_table.getValueAt(sr, 4).toString();
            id_field.setText(id);
            name_field.setText(name);
            address_field.setText(address);
            phone_field.setText(hotline);
            email_field.setText(email);
        }
        
    }//GEN-LAST:event_branch_tableMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String id = findField.getText();
        System.out.println(id);
        if(id.equals("")){
            List<Branch> branches = BranchDAO.getAllBranches();
            updateBranchTable(branches);
        }else{
            List<Branch> branches = BranchDAO.getAllBranchesById(id);
             updateBranchTable(branches);
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void findFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_findFieldActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdministratorScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdministratorScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address_field;
    private javax.swing.JTable branch_table;
    private javax.swing.JTextField email_field;
    private javax.swing.JTextField findField;
    private javax.swing.JTextField id_field;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField name_field;
    private javax.swing.JTextField phone_field;
    // End of variables declaration//GEN-END:variables
}
