package com.example.onlinetest.service;

import com.example.onlinetest.dto.QuestionDto;
import com.example.onlinetest.dto.Response;
import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Subject;
import com.example.onlinetest.entity.enums.QuestionType;
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
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    SubjectRepository subjectRepository;


    public List<Question> getAll() {
        List<Question> all = questionRepository.findAll();
        return all;
    }

    public Response add(QuestionDto questionDto) {
     Question question = new Question();
     question.setCorrectAnswer(questionDto.getCorrectAnswer());
        Optional<Subject> byId = subjectRepository.findById(questionDto.getSubjectId());
        if (!byId.isPresent()){
            return new Response("Xatolik",false);
        }
        question.setSubject(byId.get());
     question.setText(questionDto.getText());
     question.setType(QuestionType.valueOf(questionDto.getType()));
     questionRepository.save(question);
        return new Response("Qo'shildi",true);
    }
    public Response edit(UUID id, QuestionDto questionDto) {

        Optional<Question> byId1 = questionRepository.findById(id);

        if (!byId1.isPresent()){
            return new Response("Xatolik",false);
        }
        Question question = byId1.get();
        question.setCorrectAnswer(questionDto.getCorrectAnswer());
        Optional<Subject> byId = subjectRepository.findById(questionDto.getSubjectId());
        if (!byId.isPresent()){
            return new Response("Xatolik",false);
        }
        question.setSubject(byId.get());
        question.setText(questionDto.getText());
        question.setType(QuestionType.valueOf(questionDto.getType()));
        return new Response("O`zgartirildi",true);
    }

    public Response delete(UUID id) {
        questionRepository.deleteById(id);
        return new Response("O`chirildi",true);
    }
}
