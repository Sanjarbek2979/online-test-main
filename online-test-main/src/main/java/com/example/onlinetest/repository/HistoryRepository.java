package com.example.onlinetest.repository;


import com.example.onlinetest.entity.History;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface HistoryRepository extends JpaRepository<History, UUID> {
List<History> findAllByUser_Id(Long userId);
}
