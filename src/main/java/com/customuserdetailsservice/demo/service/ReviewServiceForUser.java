package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Review;

public interface ReviewServiceForUser {
    void addUserReview(Review review);
    //User setUserToReview(long reviewId, long userId);
}
