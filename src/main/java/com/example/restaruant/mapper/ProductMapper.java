package com.example.restaruant.mapper;

import com.example.restaruant.dao.entity.ProductEntity;
import com.example.restaruant.model.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ProductMapper {

    public static ProductMapper mapper = Mappers.getMapper(ProductMapper.class);


    public abstract ProductDto mapProductEntityToProductDto(ProductEntity productEntity);

    public abstract ProductEntity mapProductDtoToProductEntity(ProductDto productDto);
}


