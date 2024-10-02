package com.example.tobi.springbootessential.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class filterController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/api/data")
    public String data() {
        return "some data";
    }
}
