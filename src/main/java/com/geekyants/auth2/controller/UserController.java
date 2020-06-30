package com.geekyants.auth2.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    @Autowired
    UserRepository userRepo;

    @GetMapping("/")
    public CollectionModel<User> getAll(){
        List<User> users = userRepo.findAll();

        for (final User user : users) {
            Link selfLink = linkTo(methodOn(UserController.class).getAll()).withSelfRel();
            user.add(selfLink);
        }
        Link link = linkTo(methodOn(UserController.class).getAll()).withSelfRel();
        CollectionModel<User> result = new CollectionModel<>(users, link);

        return result;
    }
}
