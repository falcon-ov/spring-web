package com.example.springweb.controller;



import com.example.springweb.model.User;
import com.example.springweb.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    };

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable long id){
        return userService.getUserById(id);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable long id, @RequestBody User userUpd){
        return userService.updateUser(id, userUpd);
    }
    @DeleteMapping("/users/{id}")
    public boolean deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }
}
