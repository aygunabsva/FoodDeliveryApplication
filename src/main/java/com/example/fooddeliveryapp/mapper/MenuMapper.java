package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.MenuReqDTO;
import com.example.fooddeliveryapp.dto.response.MenuDTO;
import com.example.fooddeliveryapp.entity.Menu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface MenuMapper {
    MenuMapper INSTANCE = Mappers.getMapper(MenuMapper.class);
    @Mapping(source = "restaurantId", target = "restaurant.id")
    Menu toEntity(MenuReqDTO menuReqDTO);
    @Mapping(source = "restaurant.id", target = "restaurantId")
    MenuDTO toDTO(Menu menu);

}
