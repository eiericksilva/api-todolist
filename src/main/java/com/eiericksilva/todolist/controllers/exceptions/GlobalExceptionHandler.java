package com.eiericksilva.todolist.controllers.exceptions;

import java.time.LocalDateTime;

import com.eiericksilva.todolist.exceptions.DataInvalidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eiericksilva.todolist.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<SchemaError> handleResourceNotFound(ResourceNotFoundException e,
            HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        SchemaError err = new SchemaError(LocalDateTime.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(DataInvalidException.class)
    public ResponseEntity<SchemaError> handleDataInvalid(DataInvalidException e,
            HttpServletRequest request) {
        String error = "deadline cannot be earlier than the current date";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        SchemaError err = new SchemaError(LocalDateTime.now(), status.value(), error, e.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }
}
