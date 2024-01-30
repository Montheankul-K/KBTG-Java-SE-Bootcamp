package com.usermanagement.UserManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// @ResponseStatus(value = HttpStatus.NOT_FOUND)
// this exception return http status not found
public class NotFoundException extends RuntimeException {
    // exception happened on runtime
    public NotFoundException(String message) {
        super(message);
    }
}
