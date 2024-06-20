package com.happiest.minds.authenticationservice.Service;

import com.happiest.minds.authenticationservice.Entity.User;
import com.happiest.minds.authenticationservice.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private AuthRepo authRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = authRepo.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found !!"));
        return user;
    }
}

