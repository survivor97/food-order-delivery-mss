package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.RestaurantManager;
import com.group.foodorderdelivery.repository.RestaurantManagerRepository;

public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    private RestaurantManagerRepository restaurantManagerRepository;

    public RestaurantManagerServiceImpl(RestaurantManagerRepository restaurantManagerRepository) {
        this.restaurantManagerRepository = restaurantManagerRepository;
    }

    @Override
    public RestaurantManager findByUsername(String username) {
        return restaurantManagerRepository.findByUsername(username);
    }

}
