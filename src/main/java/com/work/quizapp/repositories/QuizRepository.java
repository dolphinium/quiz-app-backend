package com.work.quizapp.repositories;

import com.work.quizapp.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository {
    List<Quiz> getAllQuizzes();
    Quiz createQuiz(Quiz quiz);
}
