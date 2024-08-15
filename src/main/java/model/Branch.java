/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author PC
 */
public class Branch {

    //fields
    private String id;
    private String name;
    private String address;
    private String hotline;
    private String email;

    //constructors
    public Branch() {
    }

    public Branch(String id, String name, String address, String hotline, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.hotline = hotline;
        this.email = email;
    }

    //getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getHotline() {
        return hotline;
    }

    public String getEmail() {
        return email;
    }

    //setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHotline(String hotline) {
        this.hotline = hotline;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
