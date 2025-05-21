package com.beautyhub.beautyhubelk.interfaces;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@Slf4j
public class LogConsumer {
    private final ObjectMapper mapper = new ObjectMapper();

    @RabbitListener(queues = "${queue.name}")
    public void receiveMessage(String message) {
        try {
            Map<String, Object> data = mapper.readValue(message, Map.class);
            log.info("Received message {}", data);
            data.forEach((k, v) -> log.info(k + ": " + v));
        } catch (Exception e) {
            log.error("Failed due error", e);
        }
    }
}
