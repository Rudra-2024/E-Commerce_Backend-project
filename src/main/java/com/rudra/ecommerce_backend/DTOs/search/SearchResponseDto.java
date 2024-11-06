package com.rudra.ecommerce_backend.DTOs.search;

import com.rudra.ecommerce_backend.DTOs.products.GetProductDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

@Getter
@Setter
public class SearchResponseDto {
    private Page<GetProductDto> productsPage;
}
