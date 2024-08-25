package model;

import java.sql.Date;

/**
 *
 * @author PC
 */
public class Attendance {

    //fields
    private String id;
    private String empId;
    private Date createdDate;

    //constructors
    public Attendance() {
    }

    public Attendance(String id, String empId, Date createdDate) {
        this.id = id;
        this.empId = empId;
        this.createdDate = createdDate;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getEmpId() {
        return empId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
