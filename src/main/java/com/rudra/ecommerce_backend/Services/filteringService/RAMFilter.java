package com.rudra.ecommerce_backend.Services.filteringService;

import com.rudra.ecommerce_backend.models.Product;

import java.util.ArrayList;
import java.util.List;

public class RAMFilter implements Filter {
    @Override
    public List<Product> apply(List<Product> products, List<String> allowedValues) {
        List<Product> ans = new ArrayList<>();

        for (Product product: products) {
            if (product.getDescription().contains("")) {
                ans.add(product);
            }
        }

        return ans;
    }
}
