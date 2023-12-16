package com.digitalhouse.payments.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishNotification {
    
    private RabbitTemplate rabbitTemplate;
    
    @Autowired
    public PublishNotification(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }
    
    public void sendMessageToTopic(String message){
        rabbitTemplate.convertAndSend("send-notification", message);
    }
    
}
