package com.example.tobi.springnotice.mapper;

import com.example.tobi.springnotice.dto.NoticeResponseDTO;
import com.example.tobi.springnotice.model.Notice;
import com.example.tobi.springnotice.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {
void insertNotice(Notice notice);

    List<Notice> findAll();
}