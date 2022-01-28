package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.RestaurantManager;
import com.group.foodorderdelivery.repository.RestaurantManagerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

    Logger LOGGER = LoggerFactory.getLogger(DeliveryUserServiceImpl.class);

    private RestaurantManagerRepository restaurantManagerRepository;

    private PasswordEncoder passwordEncoder;

    public RestaurantManagerServiceImpl(RestaurantManagerRepository restaurantManagerRepository, PasswordEncoder passwordEncoder) {
        this.restaurantManagerRepository = restaurantManagerRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<RestaurantManager> findAll() {
        return restaurantManagerRepository.findAll();
    }

    @Override
    public RestaurantManager findByUsername(String username) {
        return restaurantManagerRepository.findByUsername(username);
    }

    @Override
    public void save(RestaurantManager restaurantManager) {
        LOGGER.info("Saving restaurant manager with username {" + restaurantManager.getUsername() + "} and email {" + restaurantManager.getEmail() +"}...");
        restaurantManager.setPassword(passwordEncoder.encode(restaurantManager.getPassword()));
        restaurantManagerRepository.save(restaurantManager);
    }

}
