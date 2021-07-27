package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Agenda;
import com.customuserdetailsservice.demo.model.Coins;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public void changePassword(String newPassword, long id) {
         Optional<User> user = userRepository.findById(id);
         user.get().setPassword(newPassword);
         userRepository.save(user.get());
         if (user.get().getPassword().equals(newPassword)) {
             System.out.println("Password changed");
         } else {
             throw new BadRequestException();
         }
    }

    @Override
    public Agenda bookClass(Coins coins, String password) {
        return null;
    }

    @Override
    public void buyCoins(String password) {

    }

    @Override
    public User addUser(User user) {
        List<User> list = userRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            User user2 = list.get(i);
            if (user.getUsername().equals(user2.getUsername())) {
                throw new BadRequestException();
            }
            if (user.getPassword().equals(user2.getPassword())) {
                throw new BadRequestException();
            }
        }
        userRepository.save(user);
        return user;
    }

    @Override
    public Optional<User> getUser(String username) {
        return Optional.ofNullable(userRepository.findByUsername(username));
    }


}
