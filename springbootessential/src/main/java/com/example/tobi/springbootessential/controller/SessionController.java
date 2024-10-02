package com.example.tobi.springbootessential.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SessionController {

    //로그인페이지 이동
    @GetMapping("/login")
    public String login(
            HttpSession session,
            Model model
    ) {
        String username = (String) session.getAttribute("username");

        if (username != null) {
            model.addAttribute("username", username);
        }

        return "login";
    }

    @PostMapping("/login")//form태그일경우 param body태그안에 있으면 RequestBody DTO
    public String loginExc(@RequestParam String username,
                           HttpSession session) { //세션유지
        System.out.println("username : "+username);
        session.setAttribute("username", username); // 세션값 보내기
        return "redirect:/login"; //다시 로그인페이지로감 ↑
    }

    @GetMapping
    public String logout(HttpSession session) {
        session.invalidate(); //세션무효화
        return "redirect:/login";
    }
}
