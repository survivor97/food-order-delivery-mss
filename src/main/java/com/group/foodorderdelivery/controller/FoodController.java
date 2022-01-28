package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Food;
import com.group.foodorderdelivery.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class FoodController {

    @Autowired
    private FoodService foodService;

    @GetMapping(value = "/menu", params = "restaurantId")
    public List<Food> getFoodMenuByRestaurantId(@RequestParam Long restaurantId) {
        return foodService.findByRestaurantId(restaurantId);
    }

}
