package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.repository.ReviewRepository;
import com.customuserdetailsservice.demo.service.ReviewServiceForTeacherImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ReviewServiceForTeacherTest {

    @Mock
    ReviewRepository reviewRepository;

    @InjectMocks
    private ReviewServiceForTeacherImpl reviewServiceForTeacher;

    @Captor
    ArgumentCaptor<Review> reviewCaptor;

    @Test
    public void replyFromTeacherSuccess() {
        //ARRANGE:
        Review review = new Review();
        long reviewId = 1;
        String teacherReply = "This is a reply";

        //ACT:
        when(reviewRepository.findById(reviewId)).thenReturn(Optional.of(review));
        reviewServiceForTeacher.teacherReply(teacherReply, reviewId);

        //ASSERT || VERIFY:
        verify(reviewRepository).save(reviewCaptor.capture());
        Assertions.assertEquals(reviewCaptor.getValue().getTeacherReply(), teacherReply);
    }

    @Test
    public void replyFromTeacherException() {
        Review review = new Review();
        String reply = "reply";
        long id = 1;

        when(reviewRepository.findById(id)).thenReturn(Optional.of(review));
        when(reviewRepository.save(review)).thenThrow(BadRequestException.class);

        Assertions.assertThrows(BadRequestException.class, () -> reviewServiceForTeacher.teacherReply(reply, id));
    }




}
