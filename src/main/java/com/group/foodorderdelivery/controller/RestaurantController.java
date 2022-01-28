package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/restaurants/insert")
    public ResponseEntity<?> insertRestaurant(@RequestBody Restaurant restaurant) {
        restaurantService.save(restaurant);
        return ResponseEntity.ok().body(restaurant.getId());
    }

    @PostMapping("/restaurants/setManager")
    public ResponseEntity<?> setManager(@RequestParam Long restaurantId, @RequestParam Long managerId) {
        Restaurant restaurant = restaurantService.setRestaurantManager(restaurantId, managerId);
        if(restaurant != null) {
            return ResponseEntity.ok().body(restaurant.getId());
        }
        else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problems in the post request!");
        }
    }

    @GetMapping("/restaurants/all")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.findAll();
    }

    @GetMapping(value = "/restaurants", params = "id")
    public Optional<Restaurant> getRestaurantById(@RequestParam Long id) {
        return restaurantService.findById(id);
    }

    @GetMapping(value = "/restaurants", params = "searchName")
    public List<Restaurant> getRestaurantById(@RequestParam String searchName) {
        return restaurantService.findByNameContaining(searchName);
    }

    @GetMapping(value = "/restaurants", params = "searchFood")
    public List<Restaurant> getRestaurantByFoodId(@RequestParam String searchFood) {
        return restaurantService.findByFoodNameContaining(searchFood);
    }

    @GetMapping("/restaurants/nearby")
    public List<Restaurant> getRestaurantsNearby() {
        return restaurantService.findNearbyUser();
    }

}
