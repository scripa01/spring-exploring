package com.example.springexploring.controller;


import com.example.springexploring.dto.ErrorDTO;
import com.example.springexploring.exception.CustomRuntimeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalControllerAdvice {

    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<List<ErrorDTO>> handleConstraintViolationException(ConstraintViolationException e) {
        return ResponseEntity.badRequest().body(e.getConstraintViolations()
                .stream()
                .map(error -> new ErrorDTO(error.getMessage()))
                .collect(Collectors.toList()));
    }

    @ExceptionHandler(CustomRuntimeException.class)
    public ResponseEntity<ErrorDTO> handleCustomRuntimeException(CustomRuntimeException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<ErrorDTO> handleEmptyResultDAE(EmptyResultDataAccessException e) {
        return ResponseEntity.badRequest().body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorDTO>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest().body(e.getFieldErrors()
                .stream()
                .map(error -> new ErrorDTO(error.getDefaultMessage()))
                .collect(Collectors.toList()));
    }

}
