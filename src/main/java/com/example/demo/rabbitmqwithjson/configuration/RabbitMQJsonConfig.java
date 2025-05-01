package com.example.demo.rabbitmqwithjson.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class RabbitMQJsonConfig {

    public static final String JSON_QUEUE = "json.queue";
    public static final String JSON_EXCHANGE = "json.exchange";
    public static final String JSON_ROUTING_KEY = "json.routingKey";

    @Bean
    public Queue jsonQueue() {
        return new Queue(JSON_QUEUE);
    }

    @Bean
    public DirectExchange jsonExchange() {
        return new DirectExchange(JSON_EXCHANGE);
    }

    @Bean
    public Binding jsonBinding() {
        return BindingBuilder
                .bind(jsonQueue())
                .to(jsonExchange())
                .with(JSON_ROUTING_KEY);
    }

    @Bean
    public Jackson2JsonMessageConverter jsonConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean(name = "jsonRabbitTemplate")
    public RabbitTemplate jsonRabbitTemplate(ConnectionFactory connectionFactory,
                                             Jackson2JsonMessageConverter jsonConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonConverter);
        return template;
    }
}


