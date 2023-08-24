package ru.skypro.demo.service;

import ru.skypro.demo.model.Question;

import java.util.Collection;
import java.util.Set;

public class TestConstants {
    public static final Question QUESTION_1 = new Question("i1","p1");
    public static final Question QUESTION_2 = new Question("i2","p2");
    public static final Question QUESTION_3 = new Question("i3","p3");
    public static final Question QUESTION_4 = new Question("i4","p4");
    public static final Question QUESTION_5 = new Question("i5","p5");


    public static final Question NOT_FOUND_QUESTION = new Question("NOT_FOUND","NOT_FOUND");

    public static final Collection<Question> MOCK_QUESTIONS = Set.of(
            QUESTION_1,
            QUESTION_2,
            QUESTION_3,
            QUESTION_4

    );
}
