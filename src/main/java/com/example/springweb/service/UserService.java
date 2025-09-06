package com.example.springweb.service;

import com.example.springweb.model.User;
import com.example.springweb.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    };

    public User getUserById(long id){
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    public User updateUser(long id,User userUpd){
        return userRepository.findById(id).map(user ->{
            user.setName(userUpd.getName());
            user.setAge(userUpd.getAge());
            return userRepository.save(user);
        }).orElse(null);
    }

    public boolean deleteUser(long id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
