package com.polixisTask.listener;

import com.polixisTask.model.entity.Message;
import com.polixisTask.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @Autowired
    private MessageService messageService;

    @KafkaListener(topics = "topic", groupId = "group-id")
    public void listen(Message message) {
        messageService.saveMessage(message.getContent());
    }
}
