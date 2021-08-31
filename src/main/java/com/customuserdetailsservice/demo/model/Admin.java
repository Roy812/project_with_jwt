package com.customuserdetailsservice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Admin {

    @Id
    @GeneratedValue
    private long id;

//    @Column
//    private String mailaddress;

    @Column
    private String username;

    @Column
    private String password;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

//    public String getMailaddress() {
//        return mailaddress;
//    }
//
//    public void setMailaddress(String mailaddress) {
//        this.mailaddress = mailaddress;
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
