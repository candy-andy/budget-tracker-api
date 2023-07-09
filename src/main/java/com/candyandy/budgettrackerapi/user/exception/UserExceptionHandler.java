package com.candyandy.budgettrackerapi.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public final class UserExceptionHandler {

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    ResponseEntity<Map<String, String>> handleException(SQLIntegrityConstraintViolationException e) {
        // TODO: add logging

        return ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap("error", e.getMessage()));
    }
}
