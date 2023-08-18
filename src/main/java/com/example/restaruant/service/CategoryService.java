package com.example.restaruant.service;

import com.example.restaruant.dao.entity.CategoryEntity;
import com.example.restaruant.dao.repository.CategoryRepository;
import com.example.restaruant.mapper.CategoryMapper;
import com.example.restaruant.model.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Page<CategoryDto> getCategories(Pageable pageable) {
        log.info("ActionLog.getProducts.start");
        Page<CategoryEntity> categoryEntities = categoryRepository.findAll(pageable);
        log.info("ActionLog.getProducts.end");
        return categoryEntities.map(CategoryMapper.mapper::mapCategoryEntityToCategoryDto);
    }

    public CategoryDto getCategoryId(Long id) {
        log.info("ActionLog.getCategoryId.start");
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(
                () -> {
                    throw new RuntimeException("Category not found!");
                });
        log.info("ActionLog.getCategoryId.end");
        return CategoryMapper.mapper.mapCategoryEntityToCategoryDto(categoryEntity);
    }

    public void saveCategory(CategoryDto categoryDto) {
        log.info("ActionLog.saveProduct.start");
        categoryRepository.save(CategoryMapper.mapper.mapCategoryDtoToCategoryEntity(categoryDto));
        log.info("ActionLog.saveProduct.end");
    }

    public void editCategory(CategoryEntity category, Long categoryId) {
        log.info("ActionLog.editProduct.start");
        category.setId(categoryId);
        categoryRepository.save(category);
        log.info("ActionLog.editProduct.end");
    }

    public void deleteCategory(Long categoryId) {
        log.info("ActionLog.deleteCategory.start");
        categoryRepository.deleteById(categoryId);
        log.info("ActionLog.deleteCategory.end");

    }
}