package com.example.minijobs.infrastructure.api.jobs.exception;

import com.example.minijobs.domain.jobs.exception.NoCreditsException;
import com.example.minijobs.domain.jobs.exception.UnknownUserException;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@NoArgsConstructor
public class ControllerAdvice {

    @ExceptionHandler(NoCreditsException.class)
    public ResponseEntity<Object> handleNoCreditsException(NoCreditsException e) {
        return new ResponseEntity<>("Not enough credits.", org.springframework.http.HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(UnknownUserException.class)
    public ResponseEntity<Object> handleUnknownUserException(UnknownUserException e) {
        return new ResponseEntity<>("User with the specified api-key not found.", org.springframework.http.HttpStatus.UNAUTHORIZED);
    }

}
