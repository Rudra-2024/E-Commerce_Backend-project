package com.rudra.ecommerce_backend.Services.filteringService;

public class FilterFactory {
    public static Filter getFilterFromKey(String key) {
        return switch (key) {
            case "ram" -> new RAMFilter();
            case "brand" -> new BrandFilter();
            case null, default -> null;
        };
    }
}
