package com.happiest.minds.authenticationservice.Repository;


import com.happiest.minds.authenticationservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthRepo extends JpaRepository<User,String>
{
    Optional<User> findByUsername(String email);
}

