package com.example.onlinetest.controller;

import com.example.onlinetest.entity.History;
import com.example.onlinetest.entity.User;
import com.example.onlinetest.repository.HistoryRepository;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.repository.TestRepository;
import com.example.onlinetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserPageController {
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TestRepository testRepository;
    @Autowired
    HistoryRepository historyRepository;

    @GetMapping("/history/{id}")
    public String  getHistory(@PathVariable Long id, Model model){
        List<History> allByUser_id = historyRepository.findAllByUser_Id(id);
        model.addAttribute("ketmon","User page ga xush kelibsiz!");
        User user = userRepository.findByUsernameAndPassword(HomePageController.currentUser.getUsername(),HomePageController.currentUser.getPassword()).get();
        model.addAttribute("subjects",subjectRepository.findAll());
        model.addAttribute("user",user);
        model.addAttribute("tests",testRepository.findAll());
        model.addAttribute("histories",allByUser_id);
        return "history";
    }
}
