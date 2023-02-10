package com.example.spring.config.consumer;

import com.example.spring.entity.Card;
import com.example.spring.entity.Person;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "person", partitions = {"0"}))
    public void onMessage(Person person) {
        System.out.println("------------------------------");
        System.out.println(person.getId());
        System.out.println(person.getName());
        for(Card card : person.getCards()) {
            System.out.println(card.getId());
            System.out.println(card.getName());
            System.out.println(card.getGrade());
        }
        System.out.println("------------------------------");
    }

}
