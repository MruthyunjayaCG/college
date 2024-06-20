package com.happiest.minds.authenticationservice.Service;

import com.happiest.minds.authenticationservice.Entity.User;
import com.happiest.minds.authenticationservice.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class AuthService {

    @Autowired
    private AuthRepo authRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public List<User> getUsers(){
        return authRepo.findAll();
    }

    public User createUser(User user){

        user.setUserId(UUID.randomUUID().toString());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return authRepo.save(user);
    }
}
