package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Agenda;
import com.customuserdetailsservice.demo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("agenda")
public class AgendaController {

    private AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping(value = "/bookclass")
    public ResponseEntity<Object> bookClass(@RequestBody Agenda agenda, long userId, long lessonId) {
        agendaService.bookClass(agenda, userId, lessonId);
        return ResponseEntity.ok("Booking successful");
    }

//    @GetMapping(value = "/getbookings")
//    public ResponseEntity<Object> getBookings(@RequestBody long userId) {
//        agendaService.getUserBookingsWithUserId(userId);
//        return ResponseEntity.ok("Show bookings of user with Id: " + userId);
//    }

    @DeleteMapping(value = "/deletebooking")
    public ResponseEntity<Object> deleteBooking(@RequestBody long agendaId) {
        agendaService.deleteBooking(agendaId);
        return ResponseEntity.ok("Booking deleted");
    }

}
