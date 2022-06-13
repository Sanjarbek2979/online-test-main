package com.example.onlinetest.controller;

import com.example.onlinetest.dto.LoginDto;
import com.example.onlinetest.dto.UserDto;
import com.example.onlinetest.entity.User;
import com.example.onlinetest.entity.enums.Role;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.repository.TestRepository;
import com.example.onlinetest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/")
public class HomePageController {
    public static User currentUser;
    @Autowired
    UserRepository userRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    TestRepository testRepository;


    @PostMapping("login")
    public String login(Model model, @ModelAttribute LoginDto dto) {

        if (dto.getUserName().equals("admin") && dto.getPassword().equals("admin")) {
            model.addAttribute("ketmon","Admin page ga xush kelibsiz!");
            User admin = userRepository.findByUsernameAndPassword(dto.getUserName(), dto.getPassword()).get();
            currentUser=admin;
            model.addAttribute("admin",admin);
            return "admin-page";
        } else {
            if (userRepository.existsByUsernameAndPassword(dto.getUserName(), dto.getPassword())) {

            model.addAttribute("ketmon","User page ga xush kelibsiz!");
                User user = userRepository.findByUsernameAndPassword(dto.getUserName(), dto.getPassword()).get();
                currentUser=user;
            model.addAttribute("subjects",subjectRepository.findAll());
            model.addAttribute("user",user);
            model.addAttribute("tests",testRepository.findAll());
                return "UserPage";
            }
            model.addAttribute("ketmon",false);
            return "index";
        }
    }

    @PostMapping("register")
    public String register(Model model, @ModelAttribute UserDto dto) {

        User user = new User();
        user.setRole(Role.USER);
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setName(dto.getName());
        userRepository.save(user);
        return "index";
    }


    @GetMapping("forget")
    public String registerUser(@ModelAttribute UserDto dto, Model model) {


        return "index";
    }

    @GetMapping("logOut")
    public String logout() {
        return "index";
    }


    @GetMapping("home")
    public String back(Model model) {
        model.addAttribute("ketmon","User page ga xush kelibsiz!");
        User user = userRepository.findByUsernameAndPassword(HomePageController.currentUser.getUsername(),HomePageController.currentUser.getPassword()).get();
        currentUser=user;
        model.addAttribute("subjects",subjectRepository.findAll());
        model.addAttribute("user",user);
        model.addAttribute("tests",testRepository.findAll());
        return "UserPage";
    }
}
