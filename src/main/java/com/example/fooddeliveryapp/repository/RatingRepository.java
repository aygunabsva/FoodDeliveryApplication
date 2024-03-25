package com.example.fooddeliveryapp.repository;

import com.example.fooddeliveryapp.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingRepository extends JpaRepository<Rating, Long> {

    List<Rating> findByRestaurantsNameIgnoreCase(String restaurantName);
    @Query(value = "select avg(rating_value) from rating where restaurant_id = :restaurantId", nativeQuery = true)
    Double findAverageRatingByRestaurantId(@Param("restaurantId") Long restaurantId);
}
