package com.happiest.minds.userservice.Repository;

import com.happiest.minds.userservice.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Integer> { }
