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
public class Sale {

    //fields
    private String id;
    private String branchId;
    private int targetValue;
    private Date startDate;
    private Date endDate;
    private String status;

    //constructors
    public Sale() {
    }

    public Sale(String id, String branchId, int targetValue, Date startDate, Date endDate, String status) {
        this.id = id;
        this.branchId = branchId;
        this.targetValue = targetValue;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getBranchId() {
        return branchId;
    }

    public int getTargetValue() {
        return targetValue;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public void setTargetValue(int targetValue) {
        this.targetValue = targetValue;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
