package com.example.springweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "Привет, Spring!";
    }

    @GetMapping("/hello/{name}")
    public String helloName(@PathVariable String name){
        return "Привет, "+name;
    }
}
