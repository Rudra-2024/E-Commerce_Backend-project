package com.rudra.ecommerce_backend.Services.sortingService;

import com.rudra.ecommerce_backend.DTOs.search.SortingCriteria;

public class SorterFactory {
    public static Sorter getSorterByCriteria(SortingCriteria sortingCriteria) {
        return switch (sortingCriteria) {
            case RELEVANCE -> null;
            case POPULARITY -> null;
            case PRICE_HIGH_TO_LOW -> new PriceHighToLowSorter();
            case PRICE_LOW_TO_HIGH -> new PriceLowToHighSorter();
            case RATING_HIGH_TO_LOW -> null;
            case RATING_LOW_TO_HIGH -> null;
            case null, default -> null;
        };
    }
}
