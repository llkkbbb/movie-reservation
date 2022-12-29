package com.example.springbootmoviereservationsystem.controller.exception;

import com.example.springbootmoviereservationsystem.controller.exception.dto.ExceptionResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseDto> IllegalArgumentException(final IllegalArgumentException e) {
        ExceptionResponseDto exceptionResponseDto = ExceptionResponseDto.builder()
                .status(HttpStatus.BAD_REQUEST)
                .message(e.getMessage())
                .build();

        log.info("Exception message : {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseDto);
    }

}