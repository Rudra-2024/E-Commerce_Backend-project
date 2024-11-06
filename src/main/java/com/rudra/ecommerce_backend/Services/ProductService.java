package com.rudra.ecommerce_backend.Services;

import com.rudra.ecommerce_backend.Exceptions.ProductNotFoundException;
import com.rudra.ecommerce_backend.Models.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product partialUpdateProduct(Long productId, Product product) throws ProductNotFoundException;
}
