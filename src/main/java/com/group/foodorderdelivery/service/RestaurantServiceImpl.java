package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.repository.RestaurantRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @Override
    public void save(Restaurant restaurant) {
        LOGGER.info("Saving restaurant with name {" + restaurant.getName() + "}...");
        restaurantRepository.save(restaurant);
    }
}
