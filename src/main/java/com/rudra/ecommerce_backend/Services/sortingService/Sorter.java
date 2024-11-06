package com.rudra.ecommerce_backend.Services.sortingService;

import com.rudra.ecommerce_backend.models.Product;

import java.util.List;

public interface Sorter {
    List<Product> sort(List<Product> products);
}
