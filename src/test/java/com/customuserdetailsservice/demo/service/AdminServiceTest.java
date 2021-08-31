package com.customuserdetailsservice.demo.service;

import com.customuserdetailsservice.demo.Exception.UserNotFoundException;
import com.customuserdetailsservice.demo.model.User;
import com.customuserdetailsservice.demo.repository.AdminRepository;
import com.customuserdetailsservice.demo.service.AdminServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {

    @Mock
    AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @Captor
    ArgumentCaptor<User> userCaptor;

    @Test
    public void findUserByIdSuccess() {
        //ARRANGE
        long userId = 1;

        //ACT
        User user = new User();
        user.setUserId(userId);

        //ASSERT
        when(adminRepository.findById(user.getUserId())).thenReturn(Optional.of(user));
        User user2 = adminService.getUserWithId(userId);
        Assertions.assertEquals(user, user2);
    }

    @Test
    public void findUserByIdException() {
        long id = 1;

        Assertions.assertThrows(UserNotFoundException.class, () -> adminService.getUserWithId(id));
    }

    @Test
    public void findUserByUsernameSuccess() {
        //ARRANGE
        String username = "username";

        //ACT
        User user = new User();
        user.setUsername(username);

        //ASSERT
        when(adminRepository.findByUsername(user.getUsername())).thenReturn(user);
        User user2 = adminService.getUserWithUsername(username);
        Assertions.assertEquals(user, user2);
    }

    @Test
    public void findUserByUsernameException() {
        String username = "username";

        Assertions.assertThrows(UserNotFoundException.class,() -> adminService.getUserWithUsername(username));
    }

    @Test
    public void findUserByPasswordSuccess() {
        //ARRANGE
        String password = "password";
        //ACT
        User user = new User();
        user.setPassword(password);

        //ASSERT
        when(adminRepository.findByPassword(user.getPassword())).thenReturn(user);
        User user2 = adminService.getUserWithPassword(password);
        Assertions.assertEquals(user, user2);
    }

    @Test
    public void findUserByPasswordException() {
        String password = "password";

        Assertions.assertThrows(UserNotFoundException.class, () -> adminService.getUserWithPassword(password));
    }

}
