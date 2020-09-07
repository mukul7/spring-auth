package com.geekyants.auth2.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.geekyants.auth2.entities.Detail;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.models.AuthenticationRequest;
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

import java.util.*;

@RestController
public class SignupController {
    @Autowired
    UserRepository userRepo;

    @Autowired
    DetailRepository detailRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/signup")
    public User createUser(@RequestBody Map<String, String> param) throws Exception {
        List<String> authorities = new ArrayList<>();
        authorities.add("ROLE_USER");
        User user = createUserDb(param, authorities);

        Link signUpLink = linkTo(methodOn(SignupController.class).createUser(param)).withSelfRel();
        user.add(signUpLink);
        AuthenticationRequest authBody = new AuthenticationRequest(param.get("username"),param.get("password"));
        Link authenticateLink = linkTo(methodOn(AuthenticateController.class).createAuthenticationToken(authBody)).withRel("authenticate");
        user.add(authenticateLink);
        return user;
    }

    @PostMapping("/create-admin")
    public User createAdmin(@RequestBody Map<String, String> param) throws Exception {
        List<String> authorities = new ArrayList<>();
        authorities.add("ROLE_ADMIN");
        User user = createUserDb(param, authorities);

        Link signUpLink = linkTo(methodOn(SignupController.class).createUser(param)).withSelfRel();
        user.add(signUpLink);
        AuthenticationRequest authBody = new AuthenticationRequest(param.get("username"),param.get("password"));
        Link authenticateLink = linkTo(methodOn(AuthenticateController.class).createAuthenticationToken(authBody)).withRel("authenticate");
        user.add(authenticateLink);
        return user;
    }

    private User createUserDb(Map<String, String> data, List<String> authorities){
        User user = new User();
        user.setUsername(data.get("username"));
        user.setPassword(passwordEncoder.encode(data.get("password")));
        user.setAuthorities(authorities);

        Detail detail = new Detail();
        detail.setGender(data.get("gender"));
        detail.setPhoneNumber(data.get("phoneNumber"));
        detailRepo.save(detail);

        user.setDetail(detail);
        userRepo.save(user);

        return user;
    }
}
