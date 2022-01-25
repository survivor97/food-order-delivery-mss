package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Restaurant;

import java.util.List;

public interface RestaurantService {

    void save(Restaurant restaurant);
    List<Restaurant> findAll();
    List<Restaurant> findNearbyUser();

}
