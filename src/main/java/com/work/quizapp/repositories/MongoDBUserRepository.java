package com.work.quizapp.repositories;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.work.quizapp.models.User;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import static com.mongodb.client.model.Filters.eq;

@Repository
public class MongoDBUserRepository implements UserRepository{

    private final MongoClient client;
    private MongoCollection<User> userCollection;

    public MongoDBUserRepository(MongoClient mongoClient) {
        this.client = mongoClient;
    }

    @PostConstruct
    void init() {
        userCollection = client.getDatabase("quizdb").getCollection("users", User.class);
    }
    @Override
    public User findByUsername(String username) {
        return userCollection.find(eq("username",username)).first();
    }
}
