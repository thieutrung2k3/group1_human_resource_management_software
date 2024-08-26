package view;

import dao.AccountDAO;
import dao.EmployeeDAO;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.Account;
import model.Employee;
import util.JFrameUtil;

public class LoginScreen extends javax.swing.JFrame {

    public static MaintenanceScreen maintenanceScreen;
    public static AdministratorScreen administratorScreen;
    public static EmployeeScreen employeeScreen;
    private Account account;
    private static LoginScreen instance;

    public LoginScreen() {
        initComponents();
        init();
    }

    public static LoginScreen gI() {
        if (instance == null) {
            instance = new LoginScreen();
        }
        return instance;
    }

    public void init() {
        errLoginMessage.setVisible(false);
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isFieldEmpty() {
        return jPasswordField.getPassword().length == 0 || jTextFieldUserName.getText().isEmpty();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTitle = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jButtonLogin = new javax.swing.JButton();
        jPasswordField = new javax.swing.JPasswordField();
        errLoginMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ĐĂNG NHẬP");

        jLabelTitle.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jLabelTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelTitle.setText("ĐĂNG NHẬP");
        jLabelTitle.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelUserName.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelUserName.setText("Tên đăng nhập:");
        jLabelUserName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jLabelPassword.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jLabelPassword.setText("Mật khẩu:");
        jLabelPassword.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jTextFieldUserName.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jTextFieldUserName.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        jButtonLogin.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jButtonLogin.setText("ĐĂNG NHẬP");
        jButtonLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 22)); // NOI18N
        jPasswordField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        errLoginMessage.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        errLoginMessage.setForeground(new java.awt.Color(255, 0, 0));
        errLoginMessage.setText("Đăng nhập không thành công!");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUserName, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUserName, javax.swing.GroupLayout.DEFAULT_SIZE, 297, Short.MAX_VALUE)
                            .addComponent(jPasswordField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(jLabelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(132, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(errLoginMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButtonLogin)
                        .addGap(328, 328, 328))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabelTitle)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUserName)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(errLoginMessage)
                .addGap(32, 32, 32)
                .addComponent(jButtonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoginActionPerformed
        if (!isFieldEmpty()) {
            account = new Account();
            account.setUserName(jTextFieldUserName.getText());
            char[] pass = jPasswordField.getPassword();
            String password = new String(pass);
            account.setPassword(password);
            boolean result = AccountDAO.isAccountExist(account);
            //JOptionPane.showMessageDialog(rootPane, result + ": " + account.getUserName() + "-"+account.getPassword()+"\n" +  account.getAccessRight());
            if (result) {
                Employee employee = EmployeeDAO.getEmployeeByAccountId(account.getId());
                if (account.getAccessRight().equals("Admin")) {
                    administratorScreen = new AdministratorScreen();
                    administratorScreen.setVisible(true);
                    dispose();
                } else if (account.getAccessRight().equals("User")) {

                    employeeScreen = new EmployeeScreen(employee, this.account);
                    employeeScreen.setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Tài khoản chưa được cấp quyền!"
                            + "\nVui lòng liên hệ với người quản trị.");
                }
            } else {
                errLoginMessage.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "false");
        }
    }//GEN-LAST:event_jButtonLoginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the System look and feel */
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel errLoginMessage;
    private javax.swing.JButton jButtonLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUserName;
    // End of variables declaration//GEN-END:variables
}
