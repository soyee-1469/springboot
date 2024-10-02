package com.example.tobi.springnotice.dto;

import com.example.tobi.springnotice.model.Notice;
import com.example.tobi.springnotice.model.User;
import lombok.Getter;


@Getter
public class NoticeCreateRequestDTO {
    private String userid;
    private String title;
    private String content;


    public Notice toNotice() {
        return Notice.builder()
                .userid(userid)
                .title(title)
                .content(content)
                .build();
    }
}

