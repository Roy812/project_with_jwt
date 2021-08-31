package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.model.Agenda;

import java.util.List;

public interface AgendaService {
    void bookClass(Agenda agenda, long userId, long lessonId);
//    List<Agenda> getUserBookingsWithUserId(long userId);
    void deleteBooking(long agendaId);
}
