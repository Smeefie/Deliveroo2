package Deliveroo2.JWTPrototype.controller;

import Deliveroo2.JWTPrototype.model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class TokenProducer {
    private KafkaTemplate<String, Token> kafkaTemplate;
    @Autowired
    public TokenProducer(KafkaTemplate<String, Token> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void produce(Token token) {
        this.kafkaTemplate.send("token-topic", token);
    }
}
