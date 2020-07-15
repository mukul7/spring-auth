package com.geekyants.auth2.services;

import com.geekyants.auth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JWTUserDetailsService implements UserDetailsService {



    @Autowired
    UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        com.geekyants.auth2.entities.User user = userRepo.findByUsername(username);
        List<SimpleGrantedAuthority> availableAuthorities = new ArrayList<>();
        user.getAuthorities().stream().forEach(authority -> availableAuthorities.add(new SimpleGrantedAuthority(authority)));
        return new User(user.getUsername(), user.getPassword(), availableAuthorities) {
        };
    }
}
