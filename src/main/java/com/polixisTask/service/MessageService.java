package com.polixisTask.service;

import com.polixisTask.model.entity.Message;
import com.polixisTask.model.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public void saveMessage(String content) {
        Message message = new Message();
        message.setContent(content);
        messageRepository.save(message);
    }
}
