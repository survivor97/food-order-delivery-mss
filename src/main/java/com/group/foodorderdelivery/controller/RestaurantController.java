package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurants/insert")
    public ResponseEntity<?> insertRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
        return ResponseEntity.ok().body(restaurant.getId());
    }

    @GetMapping("/restaurants/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping("/restaurants/nearby")
    public List<Restaurant> getRestaurantsNearby() {
        return restaurantService.findNearbyUser();
    }

}
