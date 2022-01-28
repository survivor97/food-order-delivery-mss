package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.model.RestaurantManager;

import java.util.List;
import java.util.Optional;

public interface RestaurantService {

    void save(Restaurant restaurant);
    List<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findByNameContaining(String keyword);
    List<Restaurant> findByFoodNameContaining(String keyword);
    List<Restaurant> findNearbyUser();
    Restaurant setRestaurantManager(Long restaurantId, Long restaurantManagerId);

}
