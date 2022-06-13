package com.example.onlinetest.controller;

import com.example.onlinetest.dto.ResultDto;
import com.example.onlinetest.dto.TestDto;
import com.example.onlinetest.entity.History;
import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Test;
import com.example.onlinetest.entity.User;
import com.example.onlinetest.repository.QuestionRepository;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.repository.TestRepository;
import com.example.onlinetest.repository.UserRepository;
import com.example.onlinetest.service.HistoryService;
import com.example.onlinetest.service.TestService;
import com.example.onlinetest.service.UserAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author Sanjarbek Allayev, пт 9:32. 25.02.2022
 */
@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    TestRepository testRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    UserAnswerService userAnswerService;
    @Autowired
    HistoryService historyService;
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/{id}")
    public String login(@PathVariable Integer id, Model model) {

        Optional<Test> byId = testRepository.findById(id);

        model.addAttribute("user",HomePageController.currentUser);
        model.addAttribute("test", byId.get());
        model.addAttribute("newtest",new ResultDto());


        return "Test";
    }

    @PostMapping("/result")
    public String register(Model model,@ModelAttribute ResultDto request ,@RequestParam Long userId,@RequestParam Integer testId) {


        List<String> objects = request.getObjects();

        Double point = userAnswerService.addAll(objects, userId, testId);
        History add = historyService.add(userId, point);
        int questions = objects.size();

        int correctAnswers= (int) (point/(100/questions));
//        model.addAttribute("history",add);
//        model.addAttribute("size",questions);
//        model.addAttribute("result",point);
//        model.addAttribute("correct",correctAnswers);
//        model.addAttribute("incorrect",questions-correctAnswers);
        model.addAttribute("user",HomePageController.currentUser);
        List<Object> obj=new ArrayList<>();
        obj.add(correctAnswers);
        obj.add(questions);
        obj.add(point);
        obj.add(questions-correctAnswers);
        model.addAttribute("all",obj);
        return "result";
    }
    @GetMapping("/subject/{id}")
    public String subjectTest(@PathVariable Integer id, Model model) {

        model.addAttribute("ketmon","User page ga xush kelibsiz!");
        User user = userRepository.findByUsernameAndPassword(HomePageController.currentUser.getUsername(),HomePageController.currentUser.getPassword()).get();
        model.addAttribute("subjects",subjectRepository.findAll());
        model.addAttribute("user",user);
        model.addAttribute("tests",testRepository.findAllBySubject_Id(id));
        return "UserPage";
    }
//
//
//    @GetMapping("/register/test")
//    public String registerTest(@ModelAttribute TestDto dto, Model model) {
//
//        return "index";
//    }


}
