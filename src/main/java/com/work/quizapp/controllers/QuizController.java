package com.work.quizapp.controllers;

import com.work.quizapp.dtos.QuizDTO;
import com.work.quizapp.models.Quiz;
import com.work.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {
    @Autowired
    private QuizService quizService;

    @GetMapping("/getAll")
    public List<QuizDTO> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("add")
    public QuizDTO createQuiz(@RequestBody QuizDTO quiz) {
        return quizService.createQuiz(quiz);
    }
}
