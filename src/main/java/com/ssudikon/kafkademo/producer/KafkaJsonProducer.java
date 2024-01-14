package com.ssudikon.kafkademo.producer;

import com.ssudikon.kafkademo.payload.Student;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaJsonProducer {

    private final KafkaTemplate<String, Student> kafkaTemplate;

    /**
     * Sends a message to the specified topic using Kafka.
     *
     * @param topic   the topic to send the message to
     * @param student the student object to include in the message
     */
    public void sendMessage(String topic, Student student) {
        log.info("Producing message {} to topic {}", student, topic);
        Message<Student> message = MessageBuilder.
                withPayload(student).
                setHeader(KafkaHeaders.TOPIC, topic).
                build();
        kafkaTemplate.send(message);
    }
}
