package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.RestaurantManager;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.service.RestaurantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestaurantManagerController {

    @Autowired
    private RestaurantManagerService restaurantManagerService;

    @GetMapping("/restaurantManagers/all")
    List<RestaurantManager> getAllRestaurantManagers() {
        return restaurantManagerService.findAll();
    }

    @PostMapping("/registerRestaurantManager")
    public ResponseEntity<?> insertUser(@RequestBody RestaurantManager restaurantManager) {
        restaurantManagerService.save(restaurantManager);
        return ResponseEntity.ok().body(restaurantManager.getId());
    }

}
