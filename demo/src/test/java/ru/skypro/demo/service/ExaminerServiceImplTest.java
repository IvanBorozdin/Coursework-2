package ru.skypro.demo.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.skypro.demo.exeption.IncorrectQuestionsAmountException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.when;
import static ru.skypro.demo.service.TestConstants.*;


@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    @Mock
    private QuestionService questionService;
   @InjectMocks
    private ExaminerServiceImpl examinerService;

@Test
   public void shouldThrowIncorrectQuestionsAmountException(){
       when(questionService.gerAll()).thenReturn(MOCK_QUESTIONS);

       assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
               .isThrownBy(() -> examinerService.getQuestions(-1));

       assertThatExceptionOfType(IncorrectQuestionsAmountException.class)
               .isThrownBy(() -> examinerService.getQuestions(MOCK_QUESTIONS.size() + 1));

   }

   @Test
    public void shouldReturnQuestions(){
       when(questionService.gerAll()).thenReturn(MOCK_QUESTIONS);
       when(questionService.getRandomQuestion()).thenReturn(
               QUESTION_1,
               QUESTION_2,
               QUESTION_3,
               QUESTION_4
       );
       int questionAmount = MOCK_QUESTIONS.size() - 2;

       assertThat(examinerService.getQuestions(questionAmount))
               .hasSize(questionAmount);


   }

}