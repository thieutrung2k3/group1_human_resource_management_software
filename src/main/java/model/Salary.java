/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Salary {

    //fields
    private String id;
    private String empId;
    private int baseSalary;
    private int additionalSalary;
    private int deduction;
    private int totalSalary;
    private Date paymentDate;

    //constructors
    public Salary() {
    }

    public Salary(String id, String empId, int baseSalary, int additionalSalary, int deduction, int totalSalary, Date paymentDate) {
        this.id = id;
        this.empId = empId;
        this.baseSalary = baseSalary;
        this.additionalSalary = additionalSalary;
        this.deduction = deduction;
        this.totalSalary = totalSalary;
        this.paymentDate = paymentDate;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getEmpId() {
        return empId;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public int getAdditionalSalary() {
        return additionalSalary;
    }

    public int getDeduction() {
        return deduction;
    }

    public int getTotalSalary() {
        return totalSalary;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public void setAdditionalSalary(int additionalSalary) {
        this.additionalSalary = additionalSalary;
    }

    public void setDeduction(int deduction) {
        this.deduction = deduction;
    }

    public void setTotalSalary(int totalSalary) {
        this.totalSalary = totalSalary;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

}
