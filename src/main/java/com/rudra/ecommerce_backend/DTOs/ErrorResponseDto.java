package com.rudra.ecommerce_backend.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseDto {
    public String status;
    public String message;
}
