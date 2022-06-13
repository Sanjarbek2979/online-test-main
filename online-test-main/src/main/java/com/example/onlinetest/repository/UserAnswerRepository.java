package com.example.onlinetest.repository;


import com.example.onlinetest.entity.UserAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer> {

}
