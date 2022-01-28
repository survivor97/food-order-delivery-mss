package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Position;
import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.service.PositionService;
import com.group.foodorderdelivery.service.RestaurantService;
import com.group.foodorderdelivery.service.RestaurantServiceImpl;
import com.group.foodorderdelivery.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class PositionController {

    private Logger LOGGER = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private PositionService positionService;

    @GetMapping(value = "/allPositions")
    public List<Position> findAllPositions() {
        return positionService.findAll();
    }

    @PostMapping(value = "/setUserPosition", params = "userId")
    public ResponseEntity<?> setUserPosition(@RequestBody Position position, @RequestParam Long userId) {
        Optional<User> user = userService.findById(userId);
        if(user.isPresent()) {
            if(user.get().getOrderLocation() == null) {
                //Insert new one
                position.setUser(user.get());
                positionService.save(position);
                return ResponseEntity.ok().body(position.getId());
            }
            else {
                //Modify the old one
                position.setId(user.get().getOrderLocation().getId());
                position.setUser(user.get());
                positionService.save(position);
                return ResponseEntity.ok().body(position.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found!");
    }

    @PostMapping(value = "/setRestaurantPosition", params = "restaurantId")
    public ResponseEntity<?> setRestaurantPosition(@RequestBody Position position, @RequestParam Long restaurantId) {
        Optional<Restaurant> restaurant =  restaurantService.findById(restaurantId);
        if(restaurant.isPresent()) {
            if(restaurant.get().getLocation() == null) {
                //Insert new one
                position.setRestaurant(restaurant.get());
                positionService.save(position);
                return ResponseEntity.ok().body(position.getId());
            }
            else {
                //Modify the old one
                position.setId(restaurant.get().getLocation().getId());
                position.setRestaurant(restaurant.get());
                positionService.save(position);
                return ResponseEntity.ok().body(position.getId());
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Restaurant not found!");
    }

}
