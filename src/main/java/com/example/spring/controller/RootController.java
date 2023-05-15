package com.example.spring.controller;

import com.example.spring.entity.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("root")
public class RootController {

    @GetMapping("aop")
    public String aopTest() {
        return "aop testing!!!";
    }

    @PostMapping("create")
    public void create(@RequestBody Card card, @RequestPart MultipartFile multipartFile) {

    }

}
