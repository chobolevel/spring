package com.example.spring.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("mail")
@RequiredArgsConstructor
public class MailController {

    private final JavaMailSender javaMailSender;

    @GetMapping("send")
    public void sendMail() {

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setTo("rodaka218@gmail.com");

        simpleMailMessage.setSubject("TEST MAIL");

        simpleMailMessage.setText("we are testing to send mail");

        javaMailSender.send(simpleMailMessage);

    }

}
