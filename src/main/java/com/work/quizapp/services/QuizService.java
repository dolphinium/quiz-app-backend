package com.work.quizapp.services;

import com.work.quizapp.dtos.QuizDTO;
import com.work.quizapp.models.Quiz;

import java.util.List;

public interface QuizService {
    List<QuizDTO> getAllQuizzes();
    QuizDTO createQuiz(QuizDTO QuizDTO);
}
