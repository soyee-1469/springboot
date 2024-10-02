package com.example.tobi.springnotice.controller;

import com.example.tobi.springnotice.dto.MemberCreateRequestDTO;
import com.example.tobi.springnotice.dto.MemberLoginRequestDTO;
import com.example.tobi.springnotice.dto.MemberResponseDTO;
import com.example.tobi.springnotice.mapper.UserMapper;
import com.example.tobi.springnotice.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class UserController {
    private final UserService userService;


    //목록출력

    //로그인페이지 이동
    @GetMapping("/login")
    public String login(
            HttpSession session,
            Model model
    ) {
        String name = (String) session.getAttribute("name");

        if (name != null) {
            model.addAttribute("name", name);
        }

        return "login";
    }

    @PostMapping("/login")//form태그일경우 param body태그안에 있으면 RequestBody DTO
    public String loginExc(@RequestParam String userid, String password,
                           HttpSession session) { //세션유지
        session.setAttribute("userid", userid);
        session.setAttribute("password",password);// 세션값 보내기
        return "redirect:/login"; //다시 로그인페이지로감 ↑
    }

    @GetMapping
    public String logout(HttpSession session) {
        session.invalidate(); //세션무효화
        return "redirect:/login";
    }


    @GetMapping("/signup")
    public String signup() {
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(@RequestBody MemberCreateRequestDTO request) {
        userService.createUser(request.toUser());
        return "redirect:/signup";
    }



}
