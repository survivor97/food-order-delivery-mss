package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.RestaurantManager;

public interface RestaurantManagerService {
    RestaurantManager findByUsername(String username);
}
