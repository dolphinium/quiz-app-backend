package com.work.quizapp.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.work.quizapp.models.Quiz;
import com.work.quizapp.models.User;
import jakarta.annotation.PostConstruct;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MongoDBQuizRepository implements QuizRepository{

    private final MongoClient client;
    private MongoCollection<Quiz> quizCollection;

    public MongoDBQuizRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        quizCollection = client.getDatabase("quizdb").getCollection("quizzes", Quiz.class);
    }
    @Override
    public List<Quiz> getAllQuizzes() {
        return quizCollection.find().into(new ArrayList<>());
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        quiz.setId(new ObjectId());
        quizCollection.insertOne(quiz);
        return quiz;
    }
}
