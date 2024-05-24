package com.work.quizapp.dtos;

import com.work.quizapp.models.User;
import org.bson.types.ObjectId;

public record UserDTO(
        String id,
        String username,
        String role
) {
    public UserDTO(User p){
        this(p.getId() == null ? new ObjectId().toHexString() : p.getId().toHexString(),
                p.getUsername(),p.getRole());
    }

    public User toUserEntity(){
        ObjectId _id = id == null ? new ObjectId() : new ObjectId(id);
        return new User(_id,username,role);
    }
}
