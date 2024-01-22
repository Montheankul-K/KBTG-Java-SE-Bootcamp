package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
public class TicketService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void produceMessageToBookTicket() {
        // send message to ticketTopic
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("ticketTopic", "Hello, world!");
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                System.out.println("Sent message with offset=[" + result.getRecordMetadata().offset() + "]");
            } else {
                System.out.println("Unable to send message due to : " + ex.getMessage());
            }
        });
    }
}
