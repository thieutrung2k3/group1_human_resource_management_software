/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dto;

/**
 *
 * @author PC
 */
public class EmployeeBranchDTO {

    //fields
    private String empId;
    private String empName;
    private String empGender;
    private String empPosition;
    private String branchName;
    private String branchAdrress;

    //constructors
    public EmployeeBranchDTO() {
    }

    public EmployeeBranchDTO(String empId, String empName, String empGender, String empPosition, String branchName, String branchAdrress) {
        this.empId = empId;
        this.empName = empName;
        this.empGender = empGender;
        this.empPosition = empPosition;
        this.branchName = branchName;
        this.branchAdrress = branchAdrress;
    }

    //getters
    public String getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getBranchAdrress() {
        return branchAdrress;
    }

    //setters
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setBranchAdrress(String branchAdrress) {
        this.branchAdrress = branchAdrress;
    }

}
