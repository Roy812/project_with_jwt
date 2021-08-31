package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.service.AdminService;
import com.customuserdetailsservice.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ReviewService reviewService;


    @GetMapping(value = "/username/{username}")
    public ResponseEntity<Object> findUserByUsername(@PathVariable("username") String username) {
        User user = adminService.getUserWithUsername(username);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/password/{password}")
    public ResponseEntity<Object> findUserByPassword(@PathVariable("password") String password) {
        User user = adminService.getUserWithPassword(password);
        return ResponseEntity.ok(user);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Object> findUserById(@PathVariable("id") long id) {
        User user = adminService.getUserWithId(id);
        return ResponseEntity.ok(user);
    }


    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable("id") long id) {
        adminService.removeUser(id);
        return ResponseEntity.ok("User deleted with id: " + id);
    }

    @PutMapping(value = "/updateuser/{id}")
    public ResponseEntity<Object> updateUserDetails(@PathVariable("id") long id, @RequestBody User user) {
        adminService.updateUserDetails(id, user);
        return ResponseEntity.ok("User Updated: ");
    }

    @DeleteMapping(value = "/review/del/{id}")
    public ResponseEntity<Object> deleteReview(@PathVariable("id") long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.ok("Review deleted from user with Id: " + id);
    }

}
