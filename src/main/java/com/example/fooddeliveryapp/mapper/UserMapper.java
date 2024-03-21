package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
     Users customerRegisterDTOToUser(CustomerRegisterDTO customerRegisterDTO);
}
