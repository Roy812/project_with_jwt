package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.User;

public interface AdminService {

    User getUserWithUsername(String username);
    User getUserWithPassword(String password);
    User getUserWithId(long id);
    void removeUser(long id);
    void updateUserDetails(long id, User user);
    //PREVIEW && GUIDEDOWNLOAD -- LESSON.


}
