package ru.skypro.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.demo.model.Question;
import ru.skypro.demo.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaController {

    private final QuestionService questionService;

    public JavaController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/add")
    public Question addQuestion(@RequestParam String question,@RequestParam String answer){
        return questionService.add(question,answer);
    }
    @GetMapping("/remove")
    public Question removeQuestion(@RequestParam String question,@RequestParam String answer){
        return questionService.remove(new Question(question,answer));
    }

    @GetMapping("/add")
    public Collection <Question> getQuestion(){
        return questionService.gerAll();
    }
}
