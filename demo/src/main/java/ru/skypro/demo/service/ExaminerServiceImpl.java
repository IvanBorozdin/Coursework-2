package ru.skypro.demo.service;

import org.springframework.stereotype.Service;
import ru.skypro.demo.exeption.IncorrectQuestionsAmountException;
import ru.skypro.demo.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService{

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount<= 0 || amount> questionService.gerAll().size() ){
            throw new IncorrectQuestionsAmountException();
        }
        Set<Question> questions = new HashSet<>();

        while (questions.size()<amount){
            questions.add(questionService.getRandomQuestion());
        }
        return null;
    }
}
