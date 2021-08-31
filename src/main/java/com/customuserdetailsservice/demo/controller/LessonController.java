package com.customuserdetailsservice.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("lesson")
public class LessonController {

    @GetMapping(value = "/preview")
    public ResponseEntity<Object> viewPreview() {
        //userService.addUser(user); AUTHENTICATED
        return new ResponseEntity<>("Preview", HttpStatus.OK);
    }

    @GetMapping(value = "/guidedownload")
    public ResponseEntity<Object> guideDownload() {
        //userService.addUser(user); AUTHENTICATED
        return new ResponseEntity<>("Guide is downloading", HttpStatus.OK);
    }

}
