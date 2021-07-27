package com.customuserdetailsservice.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long Id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int coinBalance;

    //Profile Picture??

    //Entity Relationships
    //@OneToOne (mappedBy = "user")
    //private Agenda agenda;

    //@OneToMany (mappedBy = "user")
    //private List<Coins> coins;

    //@OneToMany (mappedBy = "user")
    //private List<Review> review;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)

    private Set<Authority> authorities = new HashSet<>();

    //Getters and Setters
    public long getUserId() {
        return Id;
    }

    public void setUserId(long userId) {
        this.Id = userId;
    }

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

    public int getCoinBalance() {
        return coinBalance;
    }

    public void setCoinBalance(int coinBalance) {
        this.coinBalance = coinBalance;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

}
