package com.customuserdetailsservice.demo.controller;

import com.customuserdetailsservice.demo.model.Agenda;
import com.customuserdetailsservice.demo.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("agenda")
public class AgendaController {

    private AgendaService agendaService;

    @Autowired
    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @PostMapping(value = "/bookclass")
    public ResponseEntity<Object> bookClass(@RequestBody Agenda agenda) {
        agendaService.bookClass(agenda);
        return ResponseEntity.ok("Booking successful");
    }

}
