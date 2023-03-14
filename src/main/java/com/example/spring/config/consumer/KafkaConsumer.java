package com.example.spring.config.consumer;

import com.example.spring.entity.Card;
import com.example.spring.entity.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topicPartitions = @TopicPartition(topic = "message", partitions = {"0"}))
    public void onMessage(@Header(KafkaHeaders.GROUP_ID) String groupId, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition,  Person person) {
        log.info("---------------------------------------");
        log.info("onMessage called");
        log.info("onMessage groupId : {}", groupId);
        log.info("onMessage partition id : {}", partition);
        log.info("---------------------------------------");
    }

    @KafkaListener(topicPartitions = @TopicPartition(topic = "message", partitions = {"0"}))
    public void onMessage1(@Header(KafkaHeaders.GROUP_ID) String groupId, @Header(KafkaHeaders.RECEIVED_PARTITION_ID) int partition, Person person) {
        log.info("---------------------------------------");
        log.info("onMessage1 called");
        log.info("onMessage1 groupId : {}", groupId);
        log.info("onMessage1 partition id : {}", partition);
        log.info("---------------------------------------");
    }

}
