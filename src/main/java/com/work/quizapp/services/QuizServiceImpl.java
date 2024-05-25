package com.work.quizapp.services;

import com.work.quizapp.dtos.QuizDTO;
import com.work.quizapp.models.Quiz;
import com.work.quizapp.repositories.QuizRepository;
import org.bson.types.ObjectId;
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
        return quizRepository.findAll().stream().map(QuizDTO::new).toList();
    }

    @Override
    public QuizDTO createQuiz(QuizDTO quizDTO) {
        Quiz quiz = quizDTO.toQuizEntity();
        quiz = quizRepository.save(quiz);
        return new QuizDTO(quiz);
    }

    @Override
    public QuizDTO getQuizById(String id) {
        return quizRepository.findById(new ObjectId(id))
                .map(QuizDTO::new)
                .orElse(null);
    }
}
