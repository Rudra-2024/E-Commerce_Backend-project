package com.rudra.ecommerce_backend.Services;

import com.rudra.ecommerce_backend.DTOs.search.FilterDto;
import com.rudra.ecommerce_backend.DTOs.search.SortingCriteria;
import com.rudra.ecommerce_backend.Repositories.ProductRepository;
import com.rudra.ecommerce_backend.Services.filteringService.FilterFactory;
import com.rudra.ecommerce_backend.Services.sortingService.SorterFactory;
import com.rudra.ecommerce_backend.Models.Product;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;

    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> search(
            String query,
            List<FilterDto> filters,
            SortingCriteria sortingCriteria,
            int pageNumber, // 1    // 2
            int pageSize    // 5    // 5 -> (5 * (pageNumber - 1)) -> (pageNumber * pageSize) - 1
            //                           [5 -> 9]
    ) {
        List<Product> products = productRepository
                .findByTitleContaining(query);

        for (FilterDto filterDto: filters) {
            products = FilterFactory.getFilterFromKey(
                    filterDto.getKey()
            ).apply(products, filterDto.getValues());
        }

        products = SorterFactory.getSorterByCriteria(sortingCriteria).sort(products);

        List<Product> productsOnPage = new ArrayList<>();

        for (int i = pageSize * (pageNumber - 1); i <= (pageSize * pageNumber) - 1; ++i) {
            productsOnPage.add(products.get(i));
        }

        Pageable pageable = PageRequest.of(pageNumber, pageSize); // Adjust page number and size as needed
        return new PageImpl<>(productsOnPage, pageable, products.size());
    }

    public Page<Product> simpleSearch(
            String query,
            Long categoryId,
            int pageNumber,
            int pageSize,
            String sortingAttribute
    ) {
        // select * from products
        // where title like "%query%"
        // and categoryID = {categoryId}
        // limit {pageSize} offset pageNumbver * pageSize
        // orderBy sortingAttribute;
        Page<Product> products = productRepository
                .findAllByTitleContainingAndCategory_Id(
                        query, categoryId,
                        PageRequest.of(
                                pageNumber,
                                pageSize,
                                Sort.by(sortingAttribute).descending()));

        return products;
    }
}
