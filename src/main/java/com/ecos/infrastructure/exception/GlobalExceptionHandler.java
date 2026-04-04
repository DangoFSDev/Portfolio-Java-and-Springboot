package com.ecos.infrastructure.exception;

import com.ecos.application.dto.response.ErrorResponse;
import com.ecos.domain.exception.DomainException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<ErrorResponse> handle(DomainException ex) {

        return ResponseEntity.badRequest()
                             .body(ErrorResponse.instantiate(ex.getMessage()));
    }

}
