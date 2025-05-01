package com.example.demo.rabbitmqwithjson.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@AllArgsConstructor
@ToString
@Getter
public class MessageJson {
    private String text;
    private String sender;
    private long timestamp;

}

