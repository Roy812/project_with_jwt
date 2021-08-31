package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Review;

public interface ReviewServiceForUser {
    void addUserReview(Review review, long userId);
    //User setUserToReview(long reviewId, long userId);
}
