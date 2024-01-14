package com.ssudikon.kafkademo.controller;

import com.ssudikon.kafkademo.payload.Student;
import com.ssudikon.kafkademo.producer.KafkaJsonProducer;
import com.ssudikon.kafkademo.producer.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;
    private final KafkaJsonProducer kafkaJsonProducer;

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message) {
        kafkaProducer.sendMessage("siva-topic", message);
        return ResponseEntity.ok("Message queued for processing");
    }

    @PostMapping("/json")
    public ResponseEntity<String> sendJsonMessage(@RequestBody Student student) {
        kafkaJsonProducer.sendMessage("siva-topic", student);
        return ResponseEntity.ok("JSON Message queued for processing");
    }
}
