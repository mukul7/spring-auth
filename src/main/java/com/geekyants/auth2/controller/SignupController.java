package com.geekyants.auth2.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignupController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User createUser(@RequestBody Map<String, String> param){
        User user = new User();
        user.setUsername(param.get("username"));
        user.setPassword(passwordEncoder.encode(param.get("password")));
        user.setRole(User.Role.user);
        userRepo.save(user);
        return user;
    }
}
