package com.example.fooddeliveryapp.mapper;

import com.example.fooddeliveryapp.dto.request.RatingReqDTO;
import com.example.fooddeliveryapp.dto.response.RatingDTO;
import com.example.fooddeliveryapp.dto.response.RestaurantDTO;
import com.example.fooddeliveryapp.entity.Customer;
import com.example.fooddeliveryapp.entity.Rating;
import com.example.fooddeliveryapp.entity.Restaurant;
import com.example.fooddeliveryapp.mapper.mappingUtil.MapDateUtility;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface RatingMapper {
    RatingMapper INSTANCE = Mappers.getMapper(RatingMapper.class);
    @Mapping(source = "customerId", target = "customer.id")
    @Mapping(source = "restaurantId", target = "restaurants.id")
    Rating toEntity(RatingReqDTO dto);
    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "restaurants.id", target = "restaurantId")
    @Mapping(source = "timestamp", target = "timestamp", qualifiedByName = "mapToTimestamp")
    RatingDTO toDTO(Rating rating);

//    @Named(value = "mapToCustomer")
//    default Customer mapToCustomer(Long customerId){
//        Customer customer = new Customer();
//        customer.setId(customerId);
//        return customer;
//    }
//
//    @Named(value = "mapToRestaurant")
//    default Restaurant mapToRestaurant(Long restaurantId){
//        Restaurant restaurant = new Restaurant();
//        restaurant.setId(restaurantId);
//        return restaurant;
//    }

    @Named(value = "mapToTimestamp")
    default String mapToTimestamp(LocalDateTime dateTime){
        return MapDateUtility.mapToDateString(dateTime);
    }
}
