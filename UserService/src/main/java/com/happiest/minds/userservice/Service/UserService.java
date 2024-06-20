package com.happiest.minds.userservice.Service;

import com.happiest.minds.userservice.Entity.User;
import com.happiest.minds.userservice.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    RestTemplate restTemplate;

    public User create(@RequestBody User user){
        return userRepo.save(user);
    }


    public Optional<User> getuser(@PathVariable(name = "id") Integer id){
        return userRepo.findById(id);
    }


    public List<User> getAllUsers(){
        return userRepo.findAll();
    }


    public User update(@RequestBody User user){
        return userRepo.save(user);
    }

    public void delete(Integer id){
        userRepo.deleteById(id);
    }
}