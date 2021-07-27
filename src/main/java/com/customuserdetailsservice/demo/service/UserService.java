package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Agenda;
import com.customuserdetailsservice.demo.model.Coins;
import com.customuserdetailsservice.demo.model.User;

import java.util.Optional;

public interface UserService {

    void changePassword(String newPassword, long id);
    //Upload photo
    Agenda bookClass (Coins coins, String password);
    void buyCoins(String password);
    //PREVIEW && GUIDEDOWNLOAD -- LESSON.
    User addUser(User user);
    Optional<User> getUser(String username);


}
