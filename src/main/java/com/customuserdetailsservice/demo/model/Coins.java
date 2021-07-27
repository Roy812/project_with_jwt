package com.customuserdetailsservice.demo.model;

import javax.persistence.*;

@Entity
public class Coins {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long userid;

    @Column
    private int amount;

    @Column
    private String coinKey;

    //@ManyToOne
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    //private User user;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCoinKey() {
        return coinKey;
    }

    public void setCoinKey(String coinKey) {
        this.coinKey = coinKey;
    }

}
