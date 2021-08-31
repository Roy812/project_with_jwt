package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.Exception.RecordNotFoundException;
import com.customuserdetailsservice.demo.model.Agenda;
import com.customuserdetailsservice.demo.model.Lesson;
import com.customuserdetailsservice.demo.model.Review;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.AgendaRepository;
import com.customuserdetailsservice.demo.repository.LessonRepository;
import com.customuserdetailsservice.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    private AgendaRepository agendaRepository;
    private UserRepository userRepository;
    private LessonRepository lessonRepository;

    @Autowired
    public AgendaServiceImpl(AgendaRepository agendaRepository, UserRepository userRepository, LessonRepository lessonRepository) {
        this.agendaRepository = agendaRepository;
        this.userRepository = userRepository;
        this.lessonRepository = lessonRepository;
    }

    @Override
    public void bookClass(Agenda agenda, long userId, long lessonId) {
        try {
            Optional<User> user = userRepository.findById(userId);
            agenda.setUser(user.get());
            Optional<Lesson> lesson = lessonRepository.findById(lessonId);
            agenda.setLesson(lesson.get());
            agendaRepository.save(agenda);
        } catch (Exception e) {
            throw new BadRequestException();
        }
    }

//    @Override
//    public List<Agenda> getUserBookingsWithUserId(long userId) {
//        try {
//            Optional<User> user = userRepository.findById(userId);
//            return agendaRepository.findAgendaByUserId(userId);
//        } catch (Exception e) {
//            throw new RecordNotFoundException();
//        }
//    }

    @Override
    public void deleteBooking(long agendaId) {
        Optional<Agenda> agenda = agendaRepository.findById(agendaId);
        List<Agenda> list = agendaRepository.findAll();
        try {
            for (int i = 0; i < list.size(); i++) {
                Agenda agenda2 = list.get(i);
                if (agenda2.getId() == agendaId) {
                    agendaRepository.delete(agenda.get());
                }
            }
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }


}
