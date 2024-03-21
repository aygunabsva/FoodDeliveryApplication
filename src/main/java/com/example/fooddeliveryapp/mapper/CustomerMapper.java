package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.CustomerRegisterDTO;
import com.example.fooddeliveryapp.dto.response.CustomerDTO;
import com.example.fooddeliveryapp.entity.Authority;
import com.example.fooddeliveryapp.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

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
    Customer toEntity(CustomerRegisterDTO customerRegisterDTO);

    @Mapping(source = "id", target = "customerId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "user.username", target = "username")
    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "user.surname", target = "surname")
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "user.phone", target = "phone")
    @Mapping(source = "user.address", target = "address")
    @Mapping(source = "user.userStatus", target = "userStatus")
    CustomerDTO toDto(Customer customer);

    @Named(value = "mapAuthority")
    default String mapAuthority(Set<Authority> authorities){
        String role = null;
        for (Authority a: authorities ) {
            role = a.getName();
        }
        return role;
    }
}