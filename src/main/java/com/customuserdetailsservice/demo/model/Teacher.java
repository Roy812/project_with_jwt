package com.customuserdetailsservice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long Id;

    @Column
    private String username;

    @Column
    private String password;

    //Entity Relations
    //@OneToMany (mappedBy = "teacher")
    //private List<Lesson> lesson;

    //Getters and Setters
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
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

    //public List<Lesson> getLesson() {
      //  return lesson;
    //}

    //public void setLesson(List<Lesson> lesson) {
      //  this.lesson = lesson;
    //}


}
