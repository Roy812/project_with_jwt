package com.customuserdetailsservice.demo.service;


import com.customuserdetailsservice.demo.Exception.RecordNotFoundException;
import com.customuserdetailsservice.demo.Exception.UserNotFoundException;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminRepository repository;

    @Autowired
    public AdminServiceImpl(AdminRepository repository) {
        this.repository = repository;
    }


    @Override
    public User getUserWithUsername(String username) {
        Optional<User> user = Optional.ofNullable(repository.findByUsername(username));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found..");
        }
    }

    @Override
    public User getUserWithPassword(String password) {
        Optional<User> user = Optional.ofNullable(repository.findByPassword(password));
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found..");
        }
    }

    @Override
    public User getUserWithId(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("User not found..");
        }
    }

    @Override
    public void removeUser(long id) {
        if (repository.findById(id).isEmpty()) {
            throw new RecordNotFoundException();
        } else {
            repository.deleteById(id);
        }
    }

    @Override
    public void updateUserDetails(long id, User user) {
        Optional<User> user2 = repository.findById(id);
        if (user2.isPresent()) {
            repository.deleteById(id);
            repository.save(user);
        }
        else {
            throw new RecordNotFoundException();
        }
    }



}
