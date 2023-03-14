package com.example.spring.controller;

import com.example.spring.entity.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Controller;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("kafka")
public class KafkaController {

    private final KafkaTemplate<String, Person> kafkaTemplate;

    @PostMapping("test")
    public ResponseEntity<?> home(@RequestBody Person person) {
        ListenableFuture<SendResult<String, Person>> future = kafkaTemplate.send("message", "0", person);
        future.addCallback(new ListenableFutureCallback<SendResult<String, Person>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("FAIL TO SEND");
            }

            @Override
            public void onSuccess(SendResult<String, Person> result) {
                System.out.println("SUCCESS TO SEND");
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
