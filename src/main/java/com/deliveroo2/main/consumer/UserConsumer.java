package com.deliveroo2.main.consumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserConsumer {

    @KafkaListener(topics="${topic.name}", groupId = "$Default")
    public void consume(String message){
        System.out.println("Kafka Message received: " + message);
    }
}
