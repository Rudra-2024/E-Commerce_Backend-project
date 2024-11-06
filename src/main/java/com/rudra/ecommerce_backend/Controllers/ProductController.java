package com.rudra.ecommerce_backend.Controllers;

import com.rudra.ecommerce_backend.DTOs.products.*;
import com.rudra.ecommerce_backend.Exceptions.ProductNotFoundException;
import com.rudra.ecommerce_backend.Services.ProductService;
import com.rudra.ecommerce_backend.models.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    //   @Value("${productService}")
    //   private String productServiceType;

    private RestTemplate restTemplate;

    //    @Qualifier()
    private ProductService productService;
//
//    @Autowired
//    private String name;



    public ProductController(@Qualifier("dbProductService") ProductService productService,
                             RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @PostMapping("")
    public CreateProductResponseDto createProduct(@RequestHeader("Authorization") String token, @RequestBody CreateProductRequestDto createProductRequestDto) {
        boolean isAuthenticated = restTemplate.getForObject(
                "http://userService/auth/validate?token=" + token,
                Boolean.class
        );

        if (!isAuthenticated) {
            return null;
        }

        Product product = productService.createProduct(
                createProductRequestDto.toProduct()
        );

        return CreateProductResponseDto.fromProduct(
                product
        );
        //        return "This product is priced at: " + createProductRequestDto.getPrice();
    }

    @GetMapping("")
    public GetAllProductsResponseDto getAllProducts() {
        List<Product> products = productService.getAllProducts();
        GetAllProductsResponseDto response = new GetAllProductsResponseDto();

        List<GetProductDto> getProductResponseDtos = new ArrayList<>();

        for (Product product: products) {
            getProductResponseDtos.add(GetProductDto.from(product));
        }

        response.setProducts(getProductResponseDtos);

        return response;
    }

    @GetMapping("/{id}")
    public String getSingleProduct(@PathVariable("id") Long id) {
        return "Here is your product: " + id;
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

    }

    @PatchMapping("/{id}")
    public PatchProductResponseDto updateProduct(
            @PathVariable("id") Long productId,
            @RequestBody CreateProductDto productDto
    ) throws ProductNotFoundException {
        Product product = productService.partialUpdateProduct(
                productId,
                productDto.toProduct()
        );

        PatchProductResponseDto response = new PatchProductResponseDto();
        response.setProduct(GetProductDto.from(product));

        return response;
    }

    @PutMapping("")
    public void replaceProduct() {}

//    @RequestMapping(name = "NAMAN", value = "/products/")
//    public String tabgushijhd() {
//        return "Magic";
//    }

}
