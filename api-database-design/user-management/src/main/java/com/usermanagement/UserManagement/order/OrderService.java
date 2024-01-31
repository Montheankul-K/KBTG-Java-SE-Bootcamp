package com.usermanagement.UserManagement.order;

import com.usermanagement.UserManagement.mail.GoogleMailService;

public class OrderService {
    private GoogleMailService googleMailService;
    // order service depend on google mail service

    public OrderService() {
        this.googleMailService = new GoogleMailService();
        this.googleMailService.setUrl("mail.google.com");
        this.googleMailService.setPort("42");
    }

    public void createOrder() {
        googleMailService.sentEmail("user@gmail.com", "order created");
    }
}
