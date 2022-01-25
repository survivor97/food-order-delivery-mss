package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Food;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FoodRepository extends CrudRepository<Food, Long> {

    List<Food> findByRestaurantId(Long id);

}
