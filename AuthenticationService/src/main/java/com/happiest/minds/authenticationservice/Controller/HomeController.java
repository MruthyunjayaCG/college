package com.happiest.minds.authenticationservice.Controller;

import com.happiest.minds.authenticationservice.Entity.User;
import com.happiest.minds.authenticationservice.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private AuthService authService;


    @GetMapping("/users")
    public List<User> getUser(){
        System.out.println("getting users");
        return authService.getUsers();
    }

    @GetMapping("/current-user")
    public String getLoggedInUser(Principal principal){
        return(principal.getName());
    }

}
