package com.nooran.noorancoffeeshop.repository;

import java.util.Optional;

import com.nooran.noorancoffeeshop.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findUserByEmail(String email);

    
}
