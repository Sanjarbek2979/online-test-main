package com.example.onlinetest.repository;


import com.example.onlinetest.entity.History;
import com.example.onlinetest.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface QuestionRepository extends JpaRepository<Question, UUID> {
    Optional<Question> findById(UUID id);

    List<Question> findAllBySubject_Id(Integer id);


}
