package com.example.restaruant.controller;

import com.example.restaruant.dao.entity.CategoryEntity;
import com.example.restaruant.model.CategoryDto;
import com.example.restaruant.service.CategoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public Page<CategoryDto> getCategories(
            @PageableDefault(size = 10, page = 0, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        return categoryService.getCategories(pageable);
    }

    @GetMapping("/{id}")
    public CategoryDto getCategoryId(@PathVariable Long id) {
        return categoryService.getCategoryId(id);
    }

    @PostMapping
    public void saveCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.saveCategory(categoryDto);

    }

    @PutMapping("/{categoryId}")
    public void editCategory(@RequestBody CategoryEntity category, @PathVariable Long categoryId) {
        categoryService.editCategory(category, categoryId);
    }

    @DeleteMapping("/{categoriesId}")
    public void deleteCategory(@PathVariable Long categoriesId) {
        categoryService.deleteCategory(categoriesId);
    }

}
