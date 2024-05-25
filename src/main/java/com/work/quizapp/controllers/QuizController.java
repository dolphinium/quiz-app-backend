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

    @GetMapping
    public List<QuizDTO> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping
    public QuizDTO createQuiz(@RequestBody QuizDTO quizDTO) {
        return quizService.createQuiz(quizDTO);
    }

    @GetMapping("/{id}")
    public QuizDTO getQuizById(@PathVariable String id) {
        return quizService.getQuizById(id);
    }
}
