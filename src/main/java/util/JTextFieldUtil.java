package util;

import controller.MaintainAccountController;
import controller.MaintainBranchController;
import controller.MaintainEmployeeController;
import controller.MaintainSaleController;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import model.Account;
import model.Branch;
import model.Employee;
import model.Sale;

public class JTextFieldUtil {

    public static boolean isAccIdExisted(JTextField jTextFieldAccId) {
        boolean existed = false;
        String accId = jTextFieldAccId.getText();
        Account acc = MaintainAccountController.selectAccountById(accId);
        if (acc.getId().equals(accId)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Account id is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isUserNameExisted(JTextField jTextFieldUserName) {
        boolean existed = false;
        String userName = jTextFieldUserName.getText();
        Account acc = MaintainAccountController.selectAccountByUserName(userName);
        if (acc.getUserName().equals(userName)) {
            System.out.println("acc.getUserName() = " + acc.getUserName());
            System.out.println("userName = " + userName);
            existed = true;
            JOptionPane.showMessageDialog(null, "User name is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isEmpIdExisted(JTextField jTextFieldEmpId) {
        boolean existed = false;
        String empId = jTextFieldEmpId.getText();
        Employee emp = MaintainEmployeeController.selectEmployeeById(empId);
        if (emp.getId().equals(empId)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Employee id is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isEmpEmailExisted(JTextField jTextFieldEmpEmail) {
        boolean existed = false;
        String email = jTextFieldEmpEmail.getText();
        Employee emp = MaintainEmployeeController.selectEmployeeByEmail(email);
        if (emp.getEmail().equals(email)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Email is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isPhoneNumberExisted(JTextField jTextFieldEmpPhoneNo) {
        boolean existed = false;
        String phone = jTextFieldEmpPhoneNo.getText();
        Employee emp = MaintainEmployeeController.selectEmployeeByPhoneNo(phone);
        if (emp.getPhoneNumber().equals(phone)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Phone number is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isBranchNotExisted(JTextField jTextFieldBranchId) {
        boolean existed = false;
        String branch_id = jTextFieldBranchId.getText();
        Branch branch = MaintainBranchController.selectBranchById(branch_id);
        if (!branch.getId().equals(branch_id)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Branch is not existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static boolean isAccNotExisted(JTextField jTextFieldAccId) {
        boolean existed = false;
        String accId = jTextFieldAccId.getText();
        Account acc = MaintainAccountController.selectAccountById(accId);
        if (!acc.getId().equals(accId)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Account is not existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }

    public static void formatSaleValue(JTextField jTextFieldSaleValue) {
        ((PlainDocument) jTextFieldSaleValue.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                String newString = fb.getDocument().getText(0, fb.getDocument().getLength()) + string;
                if (isValidMoneyInput(newString)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                String currentText = fb.getDocument().getText(0, fb.getDocument().getLength());
                String newString = currentText.substring(0, offset) + text + currentText.substring(offset + length);
                if (isValidMoneyInput(newString)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidMoneyInput(String text) {
                return text.matches("^\\d*$");
            }
        });
    }

    public static boolean isSaleIdExisted(JTextField jTextFieldSaleId) {
        boolean existed = false;
        String saleId = jTextFieldSaleId.getText();
        Sale sale = MaintainSaleController.selectSaleById(saleId);
        if (sale.getId().equals(saleId)) {
            existed = true;
            JOptionPane.showMessageDialog(null, "Sale id is existed!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
        return existed;
    }
}
