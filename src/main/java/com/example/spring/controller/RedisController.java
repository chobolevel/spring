package com.example.spring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequiredArgsConstructor
@RequestMapping("redis")
public class RedisController {

    private final RedisTemplate<String, String> redisTemplate;

    @PostMapping("test")
    public ResponseEntity<?> redisTest() {
        redisTemplate.opsForValue().set("test", "success", 1, TimeUnit.HOURS);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
