package com.example.restaruant.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductDto {
    private double price;
    private boolean status;
    private String image;
    private String description;
    private CategoryDto categoryDto;
}
