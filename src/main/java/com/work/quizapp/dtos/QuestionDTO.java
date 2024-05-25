package com.work.quizapp.dtos;

import com.work.quizapp.models.Option;
import com.work.quizapp.models.Question;
import com.work.quizapp.models.Quiz;
import org.bson.types.ObjectId;

import java.util.List;

public record QuestionDTO(
        String text,
        List<AnswerDTO> answers
) {
    public QuestionDTO(Question q) {
        this(q.getText(),
                q.getAnswers().stream().map(AnswerDTO::new).toList());
    }

    public Question toQuestionEntity() {
        return new Question(text, answers.stream().map(AnswerDTO::toAnswerEntity).toList());
    }
}