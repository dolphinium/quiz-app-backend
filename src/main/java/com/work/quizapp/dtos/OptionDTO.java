package com.work.quizapp.dtos;

import com.work.quizapp.models.Option;
import com.work.quizapp.models.Question;
import org.bson.types.ObjectId;

public record OptionDTO(
        String id,
        String question_id,
        String optionName,
        boolean isTrue
) {
    public OptionDTO(Option p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getQuestion_id(),
                p.getOptionName(),
                p.isTrue());
    }

    public Option toOptionEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new Option(_id,question_id,optionName,isTrue);
    }
}
