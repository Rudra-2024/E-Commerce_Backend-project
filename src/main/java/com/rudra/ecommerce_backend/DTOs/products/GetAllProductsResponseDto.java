package com.rudra.ecommerce_backend.DTOs.products;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllProductsResponseDto {
    private List<GetProductDto> products;
}
