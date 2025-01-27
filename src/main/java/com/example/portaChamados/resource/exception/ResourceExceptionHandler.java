package com.example.portaChamados.resource.exception;

import com.example.portaChamados.service.exceptions.DatabaseException;
import com.example.portaChamados.service.exceptions.ResourceNotFoundExeption;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundExeption.class)
    public ResponseEntity<StandarErro> resourceNotFoundExeption(ResourceNotFoundExeption e, HttpServletRequest request) {
        String error = "Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarErro err = new StandarErro(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(err, status);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandarErro> DatabaseException(DatabaseException e, HttpServletRequest request) {
        String error = "Database error";
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandarErro err = new StandarErro(Instant.now(),status.value(), error, e.getMessage(), request.getRequestURI());
        return new ResponseEntity<>(err, status);
    }


}
