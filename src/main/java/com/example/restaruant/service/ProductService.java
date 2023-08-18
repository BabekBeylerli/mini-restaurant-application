package com.example.restaruant.service;

import com.example.restaruant.dao.entity.ProductEntity;
import com.example.restaruant.dao.repository.ProductRepository;
import com.example.restaruant.mapper.ProductMapper;
import com.example.restaruant.model.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<ProductDto> getProducts(Pageable pageable) {
        log.info("ActionLog.getProducts.start");
        Page<ProductEntity> productEntities = productRepository.findAll(pageable);
        log.info("ActionLog.getProducts.end");
        return productEntities.map(ProductMapper.mapper::mapProductEntityToProductDto);
    }

    public ProductDto getProductId(Long id) {
        log.info("ActionLog.getProductId.start");
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(
                () ->
                {
                    throw new RuntimeException("Product not found !");
                });
        log.info("ActionLog.getProductId.end");
        return ProductMapper.mapper.mapProductEntityToProductDto(productEntity);

    }

    public void saveProduct(ProductDto productDto) {
        log.info("ActionLog.saveProduct.start");
        productRepository.save(ProductMapper.mapper.mapProductDtoToProductEntity(productDto));
        log.info("ActionLog.saveProduct.end");
    }

    public void editProduct(ProductEntity product, Long productId) {
        log.info("ActionLog.editProduct.start");
        product.setId(productId);
        productRepository.save(product);
        log.info("ActionLog.editProduct.end");

    }

    public void deleteProduct(Long productId) {
        log.info("ActionLog.deleteProduct.start");
        productRepository.deleteById(productId);
        log.info("ActionLog.deleteProduct.end");
    }


}
