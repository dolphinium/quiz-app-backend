package com.work.quizapp.dtos;

import com.work.quizapp.models.Question;
import com.work.quizapp.models.Quiz;
import org.bson.types.ObjectId;

import java.util.List;

public record QuizDTO(
        String id,
        String title,
        List<QuestionDTO> questions
) {
    public QuizDTO(Quiz q) {
        this(q.getId() == null ? new ObjectId().toHexString() : q.getId().toHexString(),
                q.getTitle(),
                q.getQuestions().stream().map(QuestionDTO::new).toList());
    }

    public Quiz toQuizEntity() {
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new Quiz(_id, title, questions.stream().map(QuestionDTO::toQuestionEntity).toList());
    }
}
