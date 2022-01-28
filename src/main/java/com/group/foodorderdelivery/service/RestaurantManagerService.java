package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.RestaurantManager;

import java.util.List;

public interface RestaurantManagerService {
    List<RestaurantManager> findAll();
    RestaurantManager findByUsername(String username);
    void save(RestaurantManager restaurantManager);
}
