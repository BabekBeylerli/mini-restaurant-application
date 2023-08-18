package com.example.restaruant.mapper;

import com.example.restaruant.dao.entity.CategoryEntity;
import com.example.restaruant.model.CategoryDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CategoryMapper {
    public static CategoryMapper mapper = Mappers.getMapper(CategoryMapper.class);

    public abstract CategoryDto mapCategoryEntityToCategoryDto(CategoryEntity categoryEntity);

    public abstract CategoryEntity mapCategoryDtoToCategoryEntity(CategoryDto categoryDto);
}
