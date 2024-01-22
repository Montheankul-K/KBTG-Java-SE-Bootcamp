package com.example.demo.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class TicketService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void produceMessageToBookTicket(String data) {
        // produce data to testQueue on RabbitMQ
        rabbitTemplate.convertAndSend("testQueue", data);
    }
}
