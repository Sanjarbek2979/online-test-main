package com.example.onlinetest.controller;



import com.example.onlinetest.dto.QuestionDto;
import com.example.onlinetest.dto.Response;
import com.example.onlinetest.entity.Question;
import com.example.onlinetest.entity.Subject;
import com.example.onlinetest.entity.User;
import com.example.onlinetest.entity.enums.QuestionType;
import com.example.onlinetest.repository.QuestionRepository;
import com.example.onlinetest.repository.SubjectRepository;
import com.example.onlinetest.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/question")
public class QuestionPageController {
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    QuestionService questionService;


    @GetMapping
    public String show(Model model){
        model.addAttribute("message","All Questions");
        model.addAttribute("questionList",questionRepository.findAll());
        User currentUser = HomePageController.currentUser;
        model.addAttribute("admin",currentUser);
        model.addAttribute("subjectList",subjectRepository.findAll());
        model.addAttribute("types", QuestionType.values());

        return "QuestionCrud";
    }
    @PostMapping("/add")
    public String productSavePage(@ModelAttribute QuestionDto questionDto, Model model){
        questionService.add(questionDto);
        List<Question> questionList=questionService.getAll();
        model.addAttribute("questionList",questionList);
        List<Subject> all = subjectRepository.findAll();
        model.addAttribute("subjectList",all);
        return "redirect:/question";
    }


    @GetMapping("/update/{id}")
    public String editQuestionForm(@PathVariable UUID id, Model model) {
        model.addAttribute("question", questionRepository.findById(id).get());
        List<Subject> all = subjectRepository.findAll();
        User currentUser = HomePageController.currentUser;
        model.addAttribute("admin",currentUser);
        model.addAttribute("types",QuestionType.values());
        model.addAttribute("subjectList",all);
        return "editQuestion";
    }

    @PostMapping("/update/{id}")
    public String updateQuestion(@PathVariable UUID id,
                             @ModelAttribute("question") QuestionDto questionDto,
                             Model model) {

        Response edit = questionService.edit(id, questionDto);
        model.addAttribute("response",edit);
        model.addAttribute("questionList",questionRepository.findAll());
        List<Subject> all = subjectRepository.findAll();
        model.addAttribute("subjectList",all);
        return "redirect:/question";
    }

    @GetMapping("/delete/{id}")
    public String deleteSubject(@PathVariable UUID id, Model model) {
        questionRepository.deleteById(id);
        model.addAttribute("message","Muvaffaqiyatli o'chirildi");
        return "redirect:/question";
    }
}
