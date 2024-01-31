package com.usermanagement.UserManagement.mail;

public interface MailService {
    // can send mail if implement this interface
    void sendEmail(String email, String content);
}
