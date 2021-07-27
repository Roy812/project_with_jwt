package com.customuserdetailsservice.demo.repository;

import com.customuserdetailsservice.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<User, Long> {
      User findByPassword (String password);
      User findByUsername (String username);

}
