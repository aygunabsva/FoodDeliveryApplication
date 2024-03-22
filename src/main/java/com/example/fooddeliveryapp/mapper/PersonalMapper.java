package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.PersonalRegisterDTO;
import com.example.fooddeliveryapp.dto.response.PersonalDTO;
import com.example.fooddeliveryapp.entity.Personal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PersonalMapper {
    PersonalMapper INSTANCE = Mappers.getMapper(PersonalMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user.id", ignore = true)
    @Mapping(target = "user.username", source = "username")
    @Mapping(target = "user.name", source = "name")
    @Mapping(target = "user.surname", source = "surname")
    @Mapping(target = "user.password", source = "password")
    @Mapping(target = "user.email", source = "email")
    @Mapping(target = "user.phone", source = "phone")
    @Mapping(target = "user.address", source = "address")
    @Mapping(target = "user.userStatus", source = "userStatus")
    Personal toEntity(PersonalRegisterDTO personalRegisterDTO);

    @Mapping(source = "id", target = "personalId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.surname", target = "surname")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "user.address", target = "address")
    @Mapping(source = "user.userStatus", target = "userStatus")
    PersonalDTO toDto(Personal personal);
}