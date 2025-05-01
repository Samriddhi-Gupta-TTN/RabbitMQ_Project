package com.example.demo.rabbitmqwithjson.service;
import com.example.demo.rabbitmqwithjson.configuration.RabbitMQJsonConfig;
import com.example.demo.rabbitmqwithjson.dto.MessageJson;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageJsonConsumer {

    @RabbitListener(queues = RabbitMQJsonConfig.JSON_QUEUE)
    public void receiveMessage(MessageJson messageJsonDto) {
        System.out.println("Received MessageJson: " + messageJsonDto);
    }
}
