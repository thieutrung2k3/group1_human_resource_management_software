/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author PC
 */
public class AttendanceDetail {

    //fields
    private String id;
    private String attendanceId;
    private Time checkInTime;
    private Time checkOutTime;
    private Date attendanceDate;
    private String status;

    //constructors
    public AttendanceDetail() {
    }

    public AttendanceDetail(String id, String attendanceId, Time checkInTime, Time checkOutTime, Date attendanceDate) {
        this.id = id;
        this.attendanceId = attendanceId;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
        this.attendanceDate = attendanceDate;
        
    }

    //getters
    public String getId() {
        return id;
    }

    public String getAttendanceId() {
        return attendanceId;
    }

    public Time getCheckInTime() {
        return checkInTime;
    }

    public Time getCheckOutTime() {
        return checkOutTime;
    }

    public Date getAttendanceDate() {
        return attendanceDate;
    }
    public String getStatus(){
        return status;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    public void setCheckInTime(Time checkInTime) {
        this.checkInTime = checkInTime;
    }

    public void setCheckOutTime(Time checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
