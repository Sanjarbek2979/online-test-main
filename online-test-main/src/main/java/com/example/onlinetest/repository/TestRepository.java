package com.example.onlinetest.repository;

import com.example.onlinetest.entity.Test;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findAllBySubject_Id(Integer id);
}
