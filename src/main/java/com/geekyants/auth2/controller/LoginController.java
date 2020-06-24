package com.geekyants.auth2.controller;

import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginRepository loginRepo;

    @GetMapping("/")
    public String index(){
        return "hello world";
    }

    @PostMapping("/user")
    public User createUser(@RequestBody User user){
        return loginRepo.save(user);
    }
}
