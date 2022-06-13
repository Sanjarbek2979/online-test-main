package com.example.onlinetest.service;


import com.example.onlinetest.dto.QuestionDto;
import com.example.onlinetest.dto.Response;
import com.example.onlinetest.dto.TestDto;
import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Subject;
import com.example.onlinetest.entity.Test;
import com.example.onlinetest.repository.QuestionRepository;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TestService {
    @Autowired
    TestRepository testRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    SubjectRepository subjectRepository;

    public List<Test> getAll() {
        return testRepository.findAll();
    }

    public Response add(TestDto testDto) {

        HashSet<Question> questions = new HashSet<>();
        Test test = new Test();

        Optional<Subject> byId = subjectRepository.findById(testDto.getSubjectId());
        if (byId.isEmpty()) {
            return new Response("Xatolik", false);
        }
        test.setSubject(byId.get());
        test.setTime(testDto.getTime() * 60000);

        List<Question> allBySubject_id = questionRepository.findAllBySubject_Id(testDto.getSubjectId());
        if (testDto.getAmountOfQuestions() > allBySubject_id.size()) {
            return new Response("Xatolik", false);
        }
        while (questions.size() != testDto.getAmountOfQuestions()) {
            Random random = new Random();
            int i = random.nextInt(0, allBySubject_id.size() - 1);
            questions.add(allBySubject_id.get(i));
        }
        test.setQuestions((List<Question>) questions);

        Test save = testRepository.save(test);
        return new Response("Qo'shildi", true);
    }

    public Response delete(int id) {
        testRepository.deleteById(id);
        return new Response("O`chirildi", true);
    }
}
