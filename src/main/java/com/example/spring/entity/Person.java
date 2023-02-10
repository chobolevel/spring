package com.example.spring.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private String id;
    private String name;
    private List<String> cards;

}
