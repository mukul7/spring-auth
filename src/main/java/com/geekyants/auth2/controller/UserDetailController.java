package com.geekyants.auth2.controller;

import com.geekyants.auth2.entities.Detail;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.DetailRepository;
import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/users/{id}/detail")
public class UserDetailController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    DetailRepository detailRepo;

    @GetMapping("/")
    public Detail getDetail(@PathVariable Long user_id){
        User user = userRepo.getOne(user_id);
        return user.getDetail();

    }
}
