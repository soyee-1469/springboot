package com.example.tobi.springnotice.controller;

import com.example.tobi.springnotice.dto.MemberCreateRequestDTO;
import com.example.tobi.springnotice.dto.NoticeCreateRequestDTO;
import com.example.tobi.springnotice.dto.NoticeResponseDTO;
import com.example.tobi.springnotice.mapper.NoticeMapper;
import com.example.tobi.springnotice.mapper.UserMapper;
import com.example.tobi.springnotice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class NoticeController {
    private final NoticeMapper noticeMapper;
    private final UserService userService;

    @GetMapping("/notice")
    public String notice() {
        return "notice";
    }


    @PostMapping("/notice")
    public String createNotice(@RequestBody NoticeCreateRequestDTO request){
        noticeMapper.insertNotice(request.toNotice());
        return "redirect:/notice";
    }

    @GetMapping("/notice-write")
    public String noticewrite() {
        return "notice-write";
    }

    @GetMapping
    public String findAllUsers(Model model) {
        List<NoticeResponseDTO> list = userService.findAll();
        model.addAttribute("Notice", list);
        return "Notice";
    }

}
