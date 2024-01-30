package com.usermanagement.UserManagement.mail;

public class GoogleMailService implements MailService{

    private String url;
    private String port;

    public GoogleMailService(){}

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sentEmail(String to, String body) {}

    @Override
    public void sendEmail(String email, String content) {
        System.out.println("sent by google");
    }
}
