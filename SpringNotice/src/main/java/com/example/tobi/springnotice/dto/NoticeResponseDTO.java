package com.example.tobi.springnotice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class NoticeResponseDTO {
    private int no;
    private String userid;
    private String title;
    private String content;
    private int date;



}
