package com.polixisTask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "topic";

    @PostMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        kafkaTemplate.send(TOPIC, message);
        return "Message published successfully";
    }
}
