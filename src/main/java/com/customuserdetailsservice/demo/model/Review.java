package com.customuserdetailsservice.demo.model;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String review;

    @Column
    private long userid;

    @Column
    private String teacherReply;

    //Relations
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

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public String getTeacherReply() {
        return teacherReply;
    }

    public void setTeacherReply(String teacherReply) {
        this.teacherReply = teacherReply;
    }

    public long getUserid() {
        return userid;
    }

    public void setUser_id(long userid) {
        this.userid = userid;
    }

    //public User getUser() {
      //  return user;
    //}

    //public void setUser(User user) {
      //  this.user = user;
    //}


}
