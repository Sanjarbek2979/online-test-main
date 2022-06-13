package com.example.onlinetest.service;


import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Test;
import com.example.onlinetest.entity.UserAnswer;
import com.example.onlinetest.repository.TestRepository;
import com.example.onlinetest.repository.UserAnswerRepository;
import com.example.onlinetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAnswerService {
    @Autowired
    UserAnswerRepository userAnswerRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    UserRepository userRepository;

    public Double addAll(List<String> objects, Long userId, Integer testId) {

        Double score = 0d;
        Test test = testRepository.getById(testId);
        List<Question> questions = test.getQuestions();
        for (int i = 0; i < questions.size(); i++) {
            UserAnswer userAnswer = new UserAnswer();
            userAnswer.setUser(userRepository.getById(userId));
            userAnswer.setGivenAnswer((String) objects.get(i));
            userAnswer.setQuestion(questions.get(i));
            userAnswerRepository.save(userAnswer);

            if (questions.get(i).getCorrectAnswer().equals(objects.get(i).trim().toLowerCase())) {
                score += 100 / questions.size();
            }
            if(score>=99){
                score=100d;
            }
        }
        return score;
    }
}
