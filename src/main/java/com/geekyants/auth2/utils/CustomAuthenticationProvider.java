package com.geekyants.auth2.utils;

import com.geekyants.auth2.entities.User;
import com.geekyants.auth2.repositories.UserRepository;
import com.geekyants.auth2.services.JWTUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    UserRepository userRepo;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    JWTUserDetailsService userDetailService;

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String name = authentication.getName();
        Object credentials = authentication.getCredentials();
        if (!(credentials instanceof String)) {
            return null;
        }
        String password = credentials.toString();
        User user = userRepo.findByUsername(name);
        if(user==null){
            throw new UsernameNotFoundException("Username not found in database");
        }

        if (!passwordEncoder.matches(password,user.getPassword())) {
            throw new BadCredentialsException("Authentication failed for " + name);
        }

        List<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
        user.getAuthorities().stream().forEach(authority -> grantedAuthorities.add(new SimpleGrantedAuthority(authority)));
        return new UsernamePasswordAuthenticationToken(name, null, grantedAuthorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
