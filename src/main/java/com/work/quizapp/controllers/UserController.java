package com.work.quizapp.controllers;

import com.work.quizapp.dtos.UserDTO;
import com.work.quizapp.models.User;
import com.work.quizapp.services.QuizService;
import com.work.quizapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public UserDTO getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
