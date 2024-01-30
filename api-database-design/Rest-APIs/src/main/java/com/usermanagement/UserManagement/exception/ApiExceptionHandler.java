package com.usermanagement.UserManagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    // catch NotFoundException with this method
    public ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException) {
        // response body
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                notFoundException.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {InternalServiceException.class})
    public ResponseEntity<Object> handleInternalService(InternalServiceException internalServiceException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                internalServiceException.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {DataExistException.class})
    public ResponseEntity<Object> handleDataExistException(DataExistException dataExistException) {
        ApiExceptionResponse apiExceptionResponse = new ApiExceptionResponse(
                dataExistException.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now()
        );
        return new ResponseEntity<>(apiExceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
