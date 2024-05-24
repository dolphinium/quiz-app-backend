package com.work.quizapp.services;

import com.work.quizapp.dtos.UserDTO;
import com.work.quizapp.models.User;

public interface UserService {
    UserDTO findByUsername(String username);
}
