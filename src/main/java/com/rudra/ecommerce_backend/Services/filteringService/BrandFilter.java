package com.rudra.ecommerce_backend.Services.filteringService;

import com.rudra.ecommerce_backend.Models.Product;

import java.util.List;

public class BrandFilter implements Filter {
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        return List.of();
    }
}
