package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    
    @GetMapping("/")
    public String helloWorld() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public String helloUser(){
        return "Hello user";
    }

    @GetMapping("/admin")
    public String helloAdmin(){
        return "Hello admin";
    }
}
