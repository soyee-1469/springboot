package com.example.tobi.springnotice.service;

import com.example.tobi.springnotice.dto.MemberResponseDTO;
import com.example.tobi.springnotice.mapper.UserMapper;
import com.example.tobi.springnotice.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;


    public void createUser(User user) {
        userMapper.insertUser(user);
    }

    public void loginUser(String userid, String password ) {
        userMapper.loginUser(userid, password);
    }

}
