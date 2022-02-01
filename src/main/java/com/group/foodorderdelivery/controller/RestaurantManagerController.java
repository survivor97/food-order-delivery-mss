package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.RestaurantManager;
import com.group.foodorderdelivery.model.Role;
import com.group.foodorderdelivery.service.RestaurantManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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
        restaurantManager.setRole(Role.RESTAURANT_MANAGER);
        restaurantManagerService.save(restaurantManager);
        return ResponseEntity.ok().body(restaurantManager.getId());
    }

}
