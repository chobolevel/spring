package com.example.spring.controller;

import com.example.spring.entity.Card;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("root")
public class RootController {

    @PostMapping("create")
    public void create(@RequestBody Card card, @RequestPart MultipartFile multipartFile) {

    }

}
