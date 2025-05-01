package com.example.demo.rabbitmqwithjson.service;
import com.example.demo.rabbitmqwithjson.configuration.RabbitMQJsonConfig;
import com.example.demo.rabbitmqwithjson.dto.MessageJson;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//@RequiredArgsConstructor
@Service
public class MessageJsonPublisher {

    private final RabbitTemplate jsonRabbitTemplate;

    public MessageJsonPublisher(@Qualifier("jsonRabbitTemplate") RabbitTemplate rabbitTemplate) {
        this.jsonRabbitTemplate = rabbitTemplate;
    }

    public void send(MessageJson dto) {
        jsonRabbitTemplate.convertAndSend(
                RabbitMQJsonConfig.JSON_EXCHANGE,
                RabbitMQJsonConfig.JSON_ROUTING_KEY,
                dto
        );
    }
}
