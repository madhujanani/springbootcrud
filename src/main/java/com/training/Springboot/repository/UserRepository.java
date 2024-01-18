package com.training.Springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.training.Springboot.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
     User findByFirstName(String firstName);
}
