package com.work.quizapp.repositories;

import com.work.quizapp.models.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> getQuestionsForQuizId(String quizId);
}
