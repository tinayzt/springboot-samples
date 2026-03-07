package com.example.springboothello.controller;

import com.example.springboothello.vo.ResultVO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping("/hello")
    public ResultVO<String> hello() {
        return ResultVO.success("Hello Spring Boot 3.x!");
    }
}