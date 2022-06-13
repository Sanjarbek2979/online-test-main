package com.example.onlinetest.repository;


import com.example.onlinetest.entity.History;
import com.example.onlinetest.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
