package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class Usercontroller {

    private UserService userService;

    public Usercontroller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        userService.addUser(user);
        return ResponseEntity.ok("New user added: " + user);
    }

    @PatchMapping(value = "/password/id/{id}")
    public ResponseEntity<Object> changeUserPassword(@PathVariable("id") long id, @RequestBody String newpassword) {
        userService.changePassword(newpassword, id);
        return ResponseEntity.ok("Password updated from user with id: " + id);
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Object> uploadPhoto() {
        //(@RequestBody Review review) in method parameters.
        //teacherService.addUser(user); USER
        return new ResponseEntity<>("Photo is uploaded", HttpStatus.OK);
    }



}
