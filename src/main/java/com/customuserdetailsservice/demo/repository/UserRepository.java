package com.customuserdetailsservice.demo.repository;

import com.customuserdetailsservice.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
