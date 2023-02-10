package com.example.spring.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

    private String id;
    private String name;
    private String grade;

}
