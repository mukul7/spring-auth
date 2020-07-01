package com.geekyants.auth2.services;

import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class JWTUserDetailsService implements UserDetailsService {



    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        com.geekyants.auth2.entities.User user = userRepo.findByUsername(username);
        ArrayList roles= new ArrayList<>();
        roles.add(user.getRole());
        return new User(user.getUsername(), user.getPassword(), new ArrayList<>()) {
        };
    }
}
