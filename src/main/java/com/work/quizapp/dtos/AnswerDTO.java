package com.work.quizapp.dtos;

import com.work.quizapp.models.Answer;

public record AnswerDTO(
        String text,
        boolean isCorrect
) {
    public AnswerDTO(Answer a) {
        this(a.getText(), a.isCorrect());
    }

    public Answer toAnswerEntity() {
        return new Answer(text, isCorrect);
    }
}
