package com.example.tobi.springnotice.service;

import com.example.tobi.springnotice.mapper.NoticeMapper;
import com.example.tobi.springnotice.mapper.UserMapper;
import com.example.tobi.springnotice.model.Notice;
import com.example.tobi.springnotice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final NoticeMapper noticeMapper;


    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void loginUser(User user) {
        userMapper.loginUser(user);
    }
    public void createNotice(Notice notice) {
        noticeMapper.insertNotice(notice);
    }

    public  findAll() {
    }
}
