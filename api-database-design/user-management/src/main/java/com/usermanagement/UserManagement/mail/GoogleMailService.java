package com.usermanagement.UserManagement.mail;

import org.springframework.beans.factory.annotation.Value;

public class GoogleMailService implements MailService{

    @Value("${mail-provider.google.url}")
    private String url;
    @Value("${mail-provider.google.url-port}")
    private String port;

    public GoogleMailService(){

    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sentEmail(String to, String body) {}

    @Override
    public void sendEmail(String email, String content) {
        System.out.println("sent by google: " + url + ":" + port);
    }
}
