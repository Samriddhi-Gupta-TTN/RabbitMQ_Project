package com.example.demo.controller;

import com.example.demo.service.MessagePublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {

    private final MessagePublisher publisher;

    public MessageController(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/send")
    public String sendMessage(@RequestParam String text) {
        publisher.send(text);
        return "Sent: " + text;
    }
}
