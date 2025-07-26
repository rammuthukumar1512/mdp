package com.mdp.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/send")
    public ResponseEntity<String> sendMessage(@RequestParam String msg) {
        kafkaTemplate.send("new-topic", msg);
        return ResponseEntity.ok("Message sent to Kafka: " + msg);
    }
}
