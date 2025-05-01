package com.example.demo.rabbitmqwithjson.controller;
import com.example.demo.rabbitmqwithjson.dto.MessageJson;
import com.example.demo.rabbitmqwithjson.service.MessageJsonPublisher;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class MessageJsonController {

    private final MessageJsonPublisher publisher;

    public MessageJsonController(MessageJsonPublisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public String sendMessage(@RequestBody MessageJson messageJsonDto) {
        publisher.send(messageJsonDto);
        return "JSON message sent to RabbitMQ!";
    }
}