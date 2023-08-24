package ru.skypro.demo.service;

import org.assertj.core.api.ObjectAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.skypro.demo.exeption.QuestionNotFoundException;
import ru.skypro.demo.model.Question;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static ru.skypro.demo.service.TestConstants.*;

class JavaQuestionServiceTest {
    private final QuestionService questionService = new JavaQuestionService();

    @BeforeEach
    public void init(){
        questionService.add(QUESTION_1);
        questionService.add(QUESTION_2);
        questionService.add(QUESTION_3);
    }
    @Test
    public void shouldAddQuestion(){
        int beforeAddCount = questionService.gerAll().size();

        assertThat(questionService.add(QUESTION_4))
                .isEqualTo(QUESTION_4)
                .isIn(questionService.gerAll());

        assertThat(questionService.gerAll()).hasSize(beforeAddCount + 1);

    }
    @Test
    public void shouldRemoveQuestion(){
        int beforeRemoveCount = questionService.gerAll().size();

        assertThat(questionService.remove(QUESTION_1))
                .isEqualTo(QUESTION_1)
                .isIn(questionService.gerAll());

        assertThat(questionService.gerAll()).hasSize(beforeRemoveCount - 1);

    }
    @Test
    public void shouldThrowQuestionNotFoundException(){
        assertThatExceptionOfType(QuestionNotFoundException.class)
                .isThrownBy(() ->questionService.remove(NOT_FOUND_QUESTION));
    }
    @Test
    public void shouldReturnAllQuestions(){
        assertThat(questionService.gerAll())
                .hasSize(3)
                .containsExactlyInAnyOrder(
                        QUESTION_1,
                        QUESTION_2,
                        QUESTION_3

                );


    }

    @Test
    public void shouldReturnRandomQuestions(){
        assertThat(questionService.getRandomQuestion())
                .isNotNull()
                .isIn(questionService.gerAll());

    }


}