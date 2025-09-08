package com.example.springweb.service;


import com.example.springweb.model.User;
import com.example.springweb.repository.UserRepository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    private final UserRepository userRepository = mock(UserRepository.class);
    private final UserService userService = new UserService(userRepository);

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
    void testGetUsersExists(){
        User user1 = new User("Alice", 25);
        User user2 = new User("Bob", 30);
        when(userRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        List<User> users = userService.getUsers();

        assertEquals(2, users.size());
        assertEquals("Alice", users.get(0).getName());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUsersNotExists(){
        when(userRepository.findAll()).thenReturn(List.of());

        List<User> users = userService.getUsers();

        assertEquals(0, users.size());
        verify(userRepository, times(1)).findAll();
    }

    @Test
    void testGetUserByIdExists(){
        User user = new User("Alice", 25);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        User result = userService.getUserById(1L);

        assertNotNull(result);
        assertEquals("Alice", result.getName());
        assertEquals(25, result.getAge());
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testGetUserByIdNotExists(){
        when(userRepository.findById(1L)).thenReturn(Optional.empty());

        User result = userService.getUserById(1L);

        assertNull(result);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testUpdateUserExists(){
        User user = new User("Alice", 25);
        User userUpd = new User("Alican", 26);
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(user);

        User updatedUser = userService.updateUser(1L, userUpd);

        assertEquals("Alican", updatedUser.getName());
        assertEquals(26 ,updatedUser.getAge());
        verify(userRepository, times(1)).findById(1L);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void testUpdateUserNotExists(){
        User userUpd = new User("Alican", 26);
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(null));

        User updatedUser = userService.updateUser(1L, userUpd);

        assertNull(updatedUser);
        verify(userRepository, times(1)).findById(1L);
    }

    @Test
    void testDeleteUserExists() {
        long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(true);

        boolean result = userService.deleteUser(userId);

        assertTrue(result);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    void testDeleteUserNotExists() {
        long userId = 1L;

        when(userRepository.existsById(userId)).thenReturn(false);

        boolean result = userService.deleteUser(userId);

        assertFalse(result);
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(0)).deleteById(userId);
    }
}
