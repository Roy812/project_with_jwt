package com.customuserdetailsservice.demo.model;

import javax.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String lessonDescription;

    //Video???

    //@ManyToMany
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    //private List<Agenda> agenda;

    //@ManyToOne
    //@Cascade(org.hibernate.annotations.CascadeType.ALL)
    //private Teacher teacher;

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonDescription() {
        return lessonDescription;
    }

    public void setLessonDescription(String lessonDescription) {
        this.lessonDescription = lessonDescription;
    }


}
