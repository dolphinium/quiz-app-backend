package com.work.quizapp.dtos;

import com.work.quizapp.models.Quiz;
import org.bson.types.ObjectId;

public record QuizDTO(
        String id,
        String question,
        String answer
) {
    public QuizDTO(Quiz p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getQuestion(),p.getAnswer()
                );
    }

    public Quiz toQuizEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new Quiz(_id,question,answer);
    }
}
