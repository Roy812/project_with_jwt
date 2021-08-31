package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Teacher;
import com.customuserdetailsservice.demo.service.ReviewServiceForTeacher;
import com.customuserdetailsservice.demo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("teacher")
public class TeacherController {

    private TeacherService teacherService;
    private ReviewServiceForTeacher reviewServiceForTeacher;

    @Autowired
    public TeacherController(TeacherService teacherService, ReviewServiceForTeacher reviewServiceForTeacher) {
        this.teacherService = teacherService;
        this.reviewServiceForTeacher = reviewServiceForTeacher;
    }

    @PostMapping(value = "/add")
    public ResponseEntity<Object> addTeacher(@RequestBody Teacher teacher) {
        teacherService.addTeacher(teacher);
        return ResponseEntity.ok("New user added:");
    }

    @PatchMapping(value = "/password/id/{id}")
    public ResponseEntity<Object> changeTeacherPassword(@PathVariable long id, @RequestBody String newpassword) {
        teacherService.changePassword(newpassword, id);
        return ResponseEntity.ok("Password update from teacher with id: " + id);
    }

    @PatchMapping(value = "/reply/id/{id}")
    public ResponseEntity<Object> replyToReview(@PathVariable ("id") long id, @RequestBody String reply) {
        reviewServiceForTeacher.teacherReply(reply, id);
        return ResponseEntity.ok("Teacher has replied");
    }

    @PostMapping(value = "/upload")
    public ResponseEntity<Object> uploadPhoto() {
        //(@RequestBody Review review) in method parameters.
        //teacherService.addUser(user); USER
        return new ResponseEntity<>("Photo is uploaded", HttpStatus.OK);
    }

}
