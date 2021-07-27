package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewServiceForUserImpl implements ReviewServiceForUser {

    private ReviewRepository reviewRepository;

    @Autowired
    public ReviewServiceForUserImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void addUserReview(Review review) {
        try {
            reviewRepository.save(review);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

    //@Override
    //public User setUserToReview(long reviewId, long userId) {
    //    Optional<User> user = userRepository.findById(userId);
    //    Optional<Review> review = reviewRepository.findById(reviewId);
    //    if (review.isPresent() && user.isPresent()) {
    //        review.get().setUser(user.get());
    //        return reviewRepositoryForUser.save(user.get());
    //    } else {
    //        throw new RecordNotFoundException();
    //    }
    //}


    //ReviewRepositoryForUser reviewRepositoryForUser , ReviewRepository reviewRepository, UserRepository userRepository


}
