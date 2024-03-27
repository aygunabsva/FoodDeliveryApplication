package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.OrderReqDTO;
import com.example.fooddeliveryapp.dto.response.OrderDTO;
import com.example.fooddeliveryapp.entity.Order;
import com.example.fooddeliveryapp.mapper.mappingUtil.MapDateUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);


    @Mapping(source = "orderTime", target = "orderTime", qualifiedByName = "mapToOrderTime")
    @Mapping(source = "restaurant.id", target = "restaurantId")
    @Mapping(source = "customer.id", target = "customerId")
    OrderDTO toDTO(Order order);

    @Mapping(source = "restaurantId", target = "restaurant.id")
    @Mapping(source = "customerId", target = "customer.id")
    Order toEntity(OrderReqDTO orderReqDTO);

    @Named(value = "mapToOrderTime")
    default String mapToOrderTime(LocalDateTime dateTime) {
        return MapDateUtility.mapToDateString(dateTime);
    }

    @Named(value = "mapLocalDateTime")
    default LocalDateTime mapLocalDateTime(String date){
        return MapDateUtility.mapToLocalDateTime(date);
    }
}
