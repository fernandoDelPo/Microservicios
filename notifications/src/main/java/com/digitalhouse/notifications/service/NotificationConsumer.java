
package com.digitalhouse.notifications.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {
    
    Logger log = LoggerFactory.getLogger(NotificationConsumer.class);
    
    @RabbitListener(queues= "send-notification")
    public void consume(String message){
        log.info("Recibiendo el mensaje del topico send-notifications "+ message);
        
    }
     
}
