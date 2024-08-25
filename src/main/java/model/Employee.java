
package model;

import java.sql.Date;

/**
 *
 * @author whyia
 */
public class Employee {

    //fields
    private String id;
    private String branchId;
    private String accountId;
    private String fullName;
    private Date dateOfBirth;
    private String address;
    private String email;
    private String phoneNumber;
    private String position;
    private String gender;

    //constructors
    public Employee() {
    }

    public Employee(String id, String branchId, String accountId, String fullName, Date dateOfBirth, String address, String email, String phoneNumber, String position, String gender) {
        this.id = id;
        this.branchId = branchId;
        this.accountId = accountId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.position = position;
        this.gender = gender;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getBranchId() {
        return branchId;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getFullName() {
        return fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getPosition() {
        return position;
    }

    public String getGender() {
        return gender;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
