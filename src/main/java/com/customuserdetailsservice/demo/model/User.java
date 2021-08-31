package com.customuserdetailsservice.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue//(strategy = GenerationType.IDENTITY)
    private long userId;

//    @Id
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private int coinBalance;

    @Column
    private boolean subscribeToNewsletter;

    @Lob
    private byte[] profilePicture;


    //RELATIONSHIP ANNOTATIONS
    @OneToMany (mappedBy = "user")
    private List<Agenda> agenda;

    @OneToMany (mappedBy = "user")
    private List<Review> reviews;

    @OneToMany(
            targetEntity = Authority.class,
            mappedBy = "username",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)


    //GETTERS & SETTERS
    private Set<Authority> authorities = new HashSet<>();

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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

    public boolean isSubscribeToNewsletter() {
        return subscribeToNewsletter;
    }

    public void setSubscribeToNewsletter(boolean subscribeToNewsletter) {
        this.subscribeToNewsletter = subscribeToNewsletter;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    public Set<Authority> getAuthorities() { return authorities; }
    public void addAuthority(Authority authority) {
        this.authorities.add(authority);
    }
    public void removeAuthority(Authority authority) {
        this.authorities.remove(authority);
    }

    public List<Agenda> getAgenda() {
        return agenda;
    }

    public void setAgenda(List<Agenda> agenda) {
        this.agenda = agenda;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}
