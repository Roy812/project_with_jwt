package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Teacher;

public interface TeacherService {

    void changePassword(String newPassword, long id);
    //Upload photo
    //PREVIEW && GUIDEDOWNLOAD -- LESSON.
    void addTeacher(Teacher teacher);
    //void replyToReview(String reply);

}
