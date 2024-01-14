package com.ssudikon.kafkademo.producer;

import com.ssudikon.kafkademo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String topic, String message) {
        log.info("Producing message {} to topic {}", message, topic);
        kafkaTemplate.send(topic, message);
    }
}
