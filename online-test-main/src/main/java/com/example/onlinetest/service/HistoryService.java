package com.example.onlinetest.service;


import com.example.onlinetest.entity.History;
import com.example.onlinetest.repository.HistoryRepository;
import com.example.onlinetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class HistoryService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    HistoryRepository historyRepository;


    public History add( Long userId, Double point) {
        History history= new History();
        history.setPoint(point);
        history.setLocalDateTime(LocalDateTime.now());
        history.setUser(userRepository.getById(userId));
        History save = historyRepository.save(history);
        return save;
    }
    public List<History> getAll(){
        List<History> all = historyRepository.findAll();
        return all;
    }
    public List<History> getAllByUserId(Long userId){
        List<History> allByUserId = historyRepository.findAllByUser_Id(userId);
        return allByUserId;
    }
}
