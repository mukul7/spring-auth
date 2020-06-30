package com.geekyants.auth2.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.geekyants.auth2.entities.Detail;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.DetailRepository;
import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class SignupController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    DetailRepository detailRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User createUser(@RequestBody Map<String, String> param){
        User user = new User();
        user.setUsername(param.get("username"));
        user.setPassword(passwordEncoder.encode(param.get("password")));
        user.setRole(User.Role.user);
        userRepo.save(user);

        Detail detail = new Detail();
        detail.setGender(param.get("gender"));
        detail.setPhoneNumber(param.get("phoneNumber"));
        detailRepo.save(detail);

        user.setDetail(detail);
        Link signUpLink = linkTo(methodOn(SignupController.class).createUser(param)).withRel("signup");
        user.add(signUpLink);
//        user.add(linkTo(methodOn(UserRepository.class).findAll()).withRel("users"));
//        user.add(Link.of("/users/"+user.getId().toString()+"","user"));
        return user;
    }
}
