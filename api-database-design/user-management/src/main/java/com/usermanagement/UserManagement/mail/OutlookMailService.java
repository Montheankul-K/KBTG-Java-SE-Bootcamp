package com.usermanagement.UserManagement.mail;

public class OutlookMailService implements MailService{

    private String url;
    private String port;

    public OutlookMailService(){}

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void sentEmail(String to, String body) {}

    @Override
    public void sendEmail(String email, String content) {
        System.out.println("sent by outlook");
    }
}
