package com.example.tobi.springnotice.dto;

import com.example.tobi.springnotice.model.User;
import lombok.Getter;


@Getter
public class MemberLoginRequestDTO {

    private String userid;
    private String password;


    public User toUser() {
        return User.builder()
                .userid(userid)
                .password(password)
                .build();
    }
}
