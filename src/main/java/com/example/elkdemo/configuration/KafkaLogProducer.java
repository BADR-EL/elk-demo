package com.example.elkdemo.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaLogProducer {
    private static final Logger logger = LoggerFactory.getLogger(KafkaLogProducer.class);

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic = "logging-topic"; // Change this to your desired topic

    public KafkaLogProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendLog(String message) {
        logger.info("Sending log message: {}", message);
        kafkaTemplate.send(topic, message);
    }
}

