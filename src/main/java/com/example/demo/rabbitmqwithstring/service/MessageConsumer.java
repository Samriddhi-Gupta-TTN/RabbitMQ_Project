package com.example.demo.rabbitmqwithstring.service;

import com.example.demo.rabbitmqwithstring.configuration.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumer {

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Received from RabbitMQ: " + message);
    }
}
