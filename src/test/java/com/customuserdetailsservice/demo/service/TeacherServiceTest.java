package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.BadRequestException;
import com.customuserdetailsservice.demo.model.Teacher;
import com.customuserdetailsservice.demo.repository.TeacherRepository;
import com.customuserdetailsservice.demo.service.TeacherServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TeacherServiceTest {

    @Mock
    TeacherRepository teacherRepository;

    @InjectMocks
    private TeacherServiceImpl teacherService;

    @Captor
    ArgumentCaptor<Teacher> teacherCaptor;

    @Test
    public void addTeacherSuccess() {
        //ARRANGE:
        Teacher teacher = new Teacher();
        teacher.setUsername("Novi");
        teacher.setPassword("Teacher");

        //ACT:
        when(teacherRepository.save(teacher)).thenReturn(teacher);
        teacherService.addTeacher(teacher);

        //ASSERT:
        verify(teacherRepository).save(teacherCaptor.capture());
        Assertions.assertEquals(teacherCaptor.getValue(), teacher);
    }

    @Test
    public void addTeacherException() {
        //ARRANGE
        Teacher teacher = new Teacher();
        teacher.setUsername("Novi");
        teacher.setPassword("Teacher");

        //ACT
        when(teacherRepository.findAll()).thenReturn(List.of(teacher));

        //ASSERT
        Assertions.assertThrows(BadRequestException.class, () -> teacherService.addTeacher(teacher));
    }

    @Test
    public void changePasswordTeacherSuccess() {
        //ARRANGE
        String newPassword = "newPassword";
        String password = "password";
        long id = 1;

        //ACT
        Teacher teacher = new Teacher();
        teacher.setPassword(password);
        teacher.setId(id);

        //ASSERT
        when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));
        teacherService.changePassword(newPassword, id);
        verify(teacherRepository).save(teacherCaptor.capture());
        Assertions.assertEquals(newPassword, teacherCaptor.getValue().getPassword());
    }

    @Test
    public void changePasswordTeacherException() {
        //ARRANGE
        String newPassword = "password";
        String password = "password";
        long id = 1;

        //ACT
        Teacher teacher = new Teacher();
        teacher.setPassword(password);
        teacher.setId(id);

        //ASSERT
        when(teacherRepository.findById(id)).thenReturn(Optional.of(teacher));
        Assertions.assertThrows(BadRequestException.class, () -> teacherService.changePassword(newPassword, id));
    }


}
