package com.example.onlinetest.controller;

import com.example.onlinetest.dto.SubjectDto;
import com.example.onlinetest.entity.User;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sanjarbek Allayev, пт 9:15. 25.02.2022
 */
@Controller
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    SubjectService subjectService;


    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("message", "All Subject");
        model.addAttribute("subjectList", subjectRepository.findAll());
        User currentUser = HomePageController.currentUser;
        model.addAttribute("admin",currentUser);
        return "SubjectCrud";
    }

    @GetMapping("/add")
    public String productSavePage(Model model) {


        return "question";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute SubjectDto subjectDTO, Model model) {

        return "question";
    }

    @GetMapping("/edit/{id}")
    public String editSubjectForm(@PathVariable Integer id, Model model) {
        model.addAttribute("subject", subjectRepository.findById(id));
        return "edit-subject";
    }

    @PostMapping("/edit/{id}")
    public String updateSubject(@PathVariable Integer id,
                                @ModelAttribute("subject") SubjectDto subject,
                                Model model) {


        return "question";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable Integer id, Model model) {
        subjectService.delete(id);
        model.addAttribute("message", "Deleted Subject!");
        model.addAttribute("subjectList", subjectRepository.findAll());
        return "question";
    }
}