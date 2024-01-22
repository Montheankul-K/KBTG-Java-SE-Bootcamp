package com.example.demo.listener;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class TicketBookingService {

    @RabbitListener(queues = "testQueue") // listener to testQueue
    public void listen(String in) {
        System.out.println("Message read from myQueue : " + in);
    }
}
