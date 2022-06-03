package com.mightyjava.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.mightyjava.domain.Role;
import com.mightyjava.domain.User;
import com.mightyjava.repository.UserRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testFindAll() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepository.findAll()).thenReturn(userList);
        Collection<User> actualFindAllResult = this.userServiceImpl.findAll();
        assertSame(userList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(this.userRepository).findAll();
    }

    @Test
    void testFindById() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        Optional<User> ofResult = Optional.of(user);
        when(this.userRepository.findById((Long) any())).thenReturn(ofResult);
        Optional<User> actualFindByIdResult = this.userServiceImpl.findById(123L);
        assertSame(ofResult, actualFindByIdResult);
        assertTrue(actualFindByIdResult.isPresent());
        verify(this.userRepository).findById((Long) any());
    }

    @Test
    void testSaveOrUpdate() {
        User user = new User();
        user.setEmail("jane.doe@example.org");
        user.setId(123L);
        user.setMobile("Mobile");
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRole(new Role());
        when(this.userRepository.saveAndFlush((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setEmail("jane.doe@example.org");
        user1.setId(123L);
        user1.setMobile("Mobile");
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRole(new Role());
        assertSame(user, this.userServiceImpl.saveOrUpdate(user1));
        verify(this.userRepository).saveAndFlush((User) any());
    }

    @Test
    void testDeleteById() {
        doNothing().when(this.userRepository).deleteById((Long) any());
        assertEquals("{\"message\":\"User deleted successfully\"}", this.userServiceImpl.deleteById(123L));
        verify(this.userRepository).deleteById((Long) any());
    }
}

