package com.customuserdetailsservice.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Agenda {

    @Id
    @GeneratedValue
    private long id;

    @Column
    private String coinKey;

    @Column
    private long lessonId;

    //Relationship Annotation
    //@OneToOne
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    //private User user;

    //@ManyToMany (mappedBy = "agenda")
    //private List<Lesson> lesson;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoinKey() {
        return coinKey;
    }

    public void setCoinKey(String coinKey) {
        this.coinKey = coinKey;
    }

    public long getLessonId() {
        return lessonId;
    }

    public void setLessonId(long lessonId) {
        this.lessonId = lessonId;
    }

}
