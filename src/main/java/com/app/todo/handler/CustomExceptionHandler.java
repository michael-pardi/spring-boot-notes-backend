package com.app.todo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(value = UsernameNotFoundException.class)
    public ResponseEntity handle(final UsernameNotFoundException exception) {
        return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
    }
}