package com.example.springweb.service;


import com.example.springweb.model.User;
import com.example.springweb.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

    @Test
    void testGetUsers(){
        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 30);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getUsers();

        assertEquals(2, users.size());
        assertEquals("Alice", users.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserById(){
        User user = new User("Alice", 25);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals(25, result.getAge());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testCreateUser(){
        User user = new User("Alice", 25);

        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser);
        assertEquals("Alice", savedUser.getName());
        assertEquals(25,savedUser.getAge());

        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testDeleteUser(){

    }
}
