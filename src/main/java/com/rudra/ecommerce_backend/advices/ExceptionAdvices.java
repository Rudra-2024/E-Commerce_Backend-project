package com.rudra.ecommerce_backend.advices;

import com.rudra.ecommerce_backend.DTOs.ErrorResponseDto;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class ExceptionAdvices {
    @ExceptionHandler(RuntimeException.class)
    public ErrorResponseDto handleRuntimeException(RuntimeException e) {
        ErrorResponseDto dto = new ErrorResponseDto();
        dto.setStatus("ERROR");
        dto.setMessage(e.getMessage());
        return dto;
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "something went wrong";
    }
}
