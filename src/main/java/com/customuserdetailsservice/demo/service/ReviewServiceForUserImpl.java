package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.ReviewRepository;
import com.customuserdetailsservice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ReviewServiceForUserImpl implements ReviewServiceForUser {

    private ReviewRepository reviewRepository;
    private UserRepository userRepository;

    @Autowired
    public ReviewServiceForUserImpl(ReviewRepository reviewRepository, UserRepository userRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void addUserReview(Review review, long userId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            review.setUser(user.get());
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }



}
