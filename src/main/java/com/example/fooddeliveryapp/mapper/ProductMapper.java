package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.ProductReqDTO;
import com.example.fooddeliveryapp.dto.request.ProductUpdateRequestDTO;
import com.example.fooddeliveryapp.dto.response.ProductDTO;
import com.example.fooddeliveryapp.entity.Product;
import com.example.fooddeliveryapp.enums.FoodCategory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "menu.id", target = "menuId")
    ProductDTO toDTO(Product product);

    @Mapping(source = "menuId", target = "menu.id")
    Product toEntity(ProductReqDTO productReqDTO);

    void updateProductFromDTO(ProductUpdateRequestDTO requestDTO, @MappingTarget Product product);

    @Mapping(source = "menu.id", target = "menuId")
    @Mapping(source = "foodCategory", target = "foodCategory", qualifiedByName = "toFoodCategoryString")
    ProductDTO toResponseDTO(Product product);

    @Named("toFoodCategoryString")
    default String toFoodCategoryString(FoodCategory foodCategory) {
        return foodCategory.toString();
    }
}