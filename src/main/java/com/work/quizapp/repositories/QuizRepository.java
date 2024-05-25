package com.work.quizapp.repositories;

import com.work.quizapp.models.Quiz;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuizRepository extends MongoRepository<Quiz, ObjectId>{
}
