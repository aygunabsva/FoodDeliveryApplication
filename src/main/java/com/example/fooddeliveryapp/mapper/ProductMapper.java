package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    @Mapping(source = "menu.id", target = "menuId")
    ProductDTO toDTO(Product product);
    @Mapping(source = "menuId", target = "menu.id")
    Product toEntity(ProductReqDTO productReqDTO);

    void updateProductFromDTO(ProductUpdateRequestDTO requestDTO, @MappingTarget Product product);

}
