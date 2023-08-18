package com.example.restaruant.controller;

import com.example.restaruant.dao.entity.ProductEntity;
import com.example.restaruant.model.ProductDto;
import com.example.restaruant.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public Page<ProductDto> getProducts(
            @PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductDto getProductId(@PathVariable Long id) {
        return productService.getProductId(id);
    }

    @PostMapping
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(productDto);

    }

    @PutMapping("/{productId}")
    public void editProduct(@RequestBody ProductEntity product, @PathVariable Long productId) {
        productService.editProduct(product, productId);
    }

    @DeleteMapping("/{productsId}")
    public void deleteProduct(@PathVariable Long productsId) {
        productService.deleteProduct(productsId);
    }
}
