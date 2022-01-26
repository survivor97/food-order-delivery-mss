package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Food;

import java.util.List;

public interface FoodService  {

    List<Food> findByRestaurantId(Long id);

}
