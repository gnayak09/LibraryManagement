package com.example.librarymanagement.service.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer
    {
        private static final Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);

        @KafkaListener(topics = "${kafka.topic.author},${kafka.topic.book}", groupId = "${spring.kafka.consumer.group-id}")
        public void listen(String message)
            {
                logger.info(String.format("Received message: %s", message));
            }
    }
