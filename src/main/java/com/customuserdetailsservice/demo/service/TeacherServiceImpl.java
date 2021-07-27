package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.Exception.RecordNotFoundException;
import com.customuserdetailsservice.demo.model.Teacher;
import com.customuserdetailsservice.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    @Autowired
    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void changePassword(String newPassword, long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        try {
            teacher.get().setPassword(newPassword);
            teacherRepository.save(teacher.get());
        } catch (Exception e) {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void addTeacher(Teacher teacher) {
        List<Teacher> list = teacherRepository.findAll();
        for (int i = 0; i < list.size(); i++) {
            Teacher teacher2 = list.get(i);
            if (teacher.getUsername().equals(teacher2.getUsername())) {
                throw new BadRequestException();
            }
            if (teacher.getPassword().equals(teacher2.getPassword())) {
                throw new BadRequestException();
            }
        }
        teacherRepository.save(teacher);
    }


}
