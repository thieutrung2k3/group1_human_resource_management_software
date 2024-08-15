/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author whyia
 */
public class Account {
    
    //fields
    private String id;
    private String userName;
    private String password;
    private String accessRight;
    
    //constructors

    public Account() {
    }

    public Account(String id, String userName, String password, String accessRight) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.accessRight = accessRight;
    }
    
    //getters

    public String getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getAccessRight() {
        return accessRight;
    }
    
    //setters

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccessRight(String accessRight) {
        this.accessRight = accessRight;
    }
    
}
