package com.example.tobi.springnotice.model;

import com.example.tobi.springnotice.dto.MemberResponseDTO;
import com.example.tobi.springnotice.dto.NoticeResponseDTO;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder //생성자대신 쓰기위해
public class Notice {
    private int no;
    private String userid;
    private String title;
    private String content;

    public NoticeResponseDTO toNoticeResponseDTO() {
        return NoticeResponseDTO.builder()
                .no(no)
                .userid(userid)
                .title(title)
                .build();
    }
}
