package ru.skypro.demo.service;

import ru.skypro.demo.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection <Question> getQuestions(int amount);
}
