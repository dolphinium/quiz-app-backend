package com.work.quizapp.services;

import com.work.quizapp.dtos.UserDTO;
import com.work.quizapp.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO findByUsername(String username) {
        return new UserDTO(userRepository.findByUsername(username));
    }
}
