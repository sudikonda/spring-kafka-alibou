package com.ssudikon.kafkademo.consumer;

import com.ssudikon.kafkademo.payload.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    public void consume(String message) {
        log.info("consuming the message {}", message);
    }

    @KafkaListener(topics = "siva-topic", groupId = "siva-kafka-consumer")
    public void consume(Student message) {
        log.info("consuming the message {}", message);
    }
}
