package ru.skypro.demo.service;

import ru.skypro.demo.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question,String answer);

    Question add(Question question);

    Question remove(Question question);

    Collection<Question> gerAll();

    Question getRandomQuestion();
    
}
