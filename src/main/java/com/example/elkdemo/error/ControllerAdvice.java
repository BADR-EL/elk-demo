package com.example.elkdemo.error;

import com.example.elkdemo.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
@Slf4j
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = { ProductNotFoundException.class})
    protected ResponseEntity<?> handleConflict( RuntimeException ex) {
        log.error(ex.getMessage());
        return new ResponseEntity<>(new Response(ex.getMessage(),null),HttpStatus.NOT_FOUND);
    }
}
