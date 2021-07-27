package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewServiceForTeacherImpl implements ReviewServiceForTeacher{

    private ReviewRepository reviewRepository;

    public ReviewServiceForTeacherImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void teacherReply(String teacherReply, long id) {
        Optional<Review> review = reviewRepository.findById(id);
        try {
            review.get().setTeacherReply(teacherReply);
            reviewRepository.save(review.get());
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }


}
