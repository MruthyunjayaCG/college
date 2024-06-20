package com.happiest.minds.authenticationservice.Configuration;

import com.happiest.minds.authenticationservice.Repository.AuthRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class AppConfig {

    @Autowired
    AuthRepo authRepo;
    @Bean
    public UserDetailsService userDetailsService(){

        UserDetails user = User.builder().username("sonu").password(passwordEncoder().encode("Sonu2002@")).roles("Admin").build();
        UserDetails user1 = User.builder().username("user1").password(passwordEncoder().encode("user1@")).roles("Admin").build();
        return new InMemoryUserDetailsManager(user, user1);

    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}

