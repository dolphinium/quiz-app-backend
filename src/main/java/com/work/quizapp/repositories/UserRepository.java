package com.work.quizapp.repositories;

import com.work.quizapp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository {
    User findByUsername(String username);
}