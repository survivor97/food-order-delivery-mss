package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurants/insert")
    public ResponseEntity<?> insertRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
        return ResponseEntity.ok().body(restaurant.getId());
    }

}
