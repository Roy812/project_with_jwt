package com.customuserdetailsservice.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Teacher {

    @Id
    @GeneratedValue
    private long Id;

    @Column
    private String username;

    @Column
    private String password;


    //RELATIONSHIP ANNOTATIONS
    @OneToMany (mappedBy = "teacher")
    private List<Lesson> lesson;


    //GETTERS & SETTERS
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

    public List<Lesson> getLesson() {
        return lesson;
    }

    public void setLesson(List<Lesson> lesson) {
        this.lesson = lesson;
    }

}
