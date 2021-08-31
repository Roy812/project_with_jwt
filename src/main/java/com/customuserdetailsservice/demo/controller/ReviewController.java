package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.service.ReviewServiceForUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("review")
public class ReviewController {

    private ReviewServiceForUser reviewServiceForUser;

    @Autowired
    public ReviewController(ReviewServiceForUser reviewServiceForUser) {
        this.reviewServiceForUser = reviewServiceForUser;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addReview(@RequestBody Review review, long userId) {
        reviewServiceForUser.addUserReview(review, userId);
        return ResponseEntity.ok("Review added");
    }

    //@PutMapping(value = "/setuser/id/{id}")
    //public ResponseEntity<Object> addUserToReview(@PathVariable("id") long userId, @RequestBody long reviewId) {
        //@PathVariable("id") long userId, @RequestBody long reviewId
    //    reviewServiceForUser.setUserToReview(reviewId, userId);
    //    return ResponseEntity.ok("Review " + reviewId + " added to user with id: " + userId);
    //}


}
