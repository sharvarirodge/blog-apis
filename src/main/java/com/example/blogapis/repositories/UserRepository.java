package com.example.blogapis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.blogapis.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
