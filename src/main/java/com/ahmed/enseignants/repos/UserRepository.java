package com.ahmed.enseignants.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ahmed.enseignants.entities.User;


public interface UserRepository extends JpaRepository<User, Long> {
      User findByUsername (String username);

}
