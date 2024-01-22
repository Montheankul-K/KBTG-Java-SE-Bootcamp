package com.example.demo.controller;

import com.example.demo.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tickets")
public class TicketController {
    @Autowired
    private TicketService ticketService;
    @PostMapping
    public ResponseEntity<String> bookTicket() {
        ticketService.produceMessageToBookTicket();
        return new ResponseEntity<>("done",HttpStatus.OK);
    }
}
