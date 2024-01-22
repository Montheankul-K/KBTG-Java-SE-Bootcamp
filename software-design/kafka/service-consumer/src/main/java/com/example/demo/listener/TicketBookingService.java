package com.example.demo.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class TicketBookingService {

    @KafkaListener(topics = "ticketTopic") // listen to ticketTopic
    // ticketTopic create on docker-compose
    public void listen(String in) {
        System.out.println("Message read from test-java-topic : " + in);
    }
}
