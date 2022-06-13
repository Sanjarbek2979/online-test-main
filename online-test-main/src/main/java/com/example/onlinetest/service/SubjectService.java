package com.example.onlinetest.service;

import com.example.onlinetest.dto.QuestionDto;
import com.example.onlinetest.dto.Response;
import com.example.onlinetest.dto.SubjectDto;
import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Subject;
import com.example.onlinetest.repository.QuestionRepository;
import com.example.onlinetest.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author Sanjarbek Allayev, чт 11:36. 31.03.2022
 */
@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    public List<Subject> getAll() {
        return subjectRepository.findAll();
    }

    public Response add(SubjectDto subjectDto) {
        Subject subject = new Subject();
        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);
        return new Response("Qo'shildi", true);
    }

    public Response edit(Integer id, SubjectDto subjectDto) {
        Optional<Subject> byId = subjectRepository.findById(id);
        if (!byId.isPresent()) {
            return new Response("Xatolik", false);
        }
        Subject subject = byId.get();

        subject.setName(subjectDto.getName());
        subjectRepository.save(subject);


        return new Response("O`zgartirildi", true);
    }

    public Response delete(int id) {
        subjectRepository.deleteById(id);
        return new Response("O`chirildi", true);
    }
}
