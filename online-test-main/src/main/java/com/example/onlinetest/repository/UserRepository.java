package com.example.onlinetest.repository;


import com.example.onlinetest.entity.History;
import com.example.onlinetest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
    boolean existsByUsernameAndPassword(String username, String password);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
