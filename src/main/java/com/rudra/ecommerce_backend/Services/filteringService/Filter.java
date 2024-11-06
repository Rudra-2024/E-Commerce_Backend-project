package com.rudra.ecommerce_backend.Services.filteringService;

import com.rudra.ecommerce_backend.Models.Product;

import java.util.List;

public interface Filter {
    List<Product> apply(List<Product> products,
                        List<String> allowedValues);
}
