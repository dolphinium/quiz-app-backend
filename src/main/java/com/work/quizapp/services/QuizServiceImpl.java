package com.work.quizapp.services;

import com.work.quizapp.dtos.QuizDTO;
import com.work.quizapp.models.Quiz;
import com.work.quizapp.repositories.QuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizServiceImpl implements QuizService{

    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public List<QuizDTO> getAllQuizzes() {
        return quizRepository.getAllQuizzes().stream().map(QuizDTO::new).toList();
    }

    @Override
    public QuizDTO createQuiz(QuizDTO QuizDTO) {
        return new QuizDTO(quizRepository.createQuiz(QuizDTO.toQuizEntity()));
    }
}
