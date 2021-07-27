package com.customuserdetailsservice.demo.repository;

import com.customuserdetailsservice.demo.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
