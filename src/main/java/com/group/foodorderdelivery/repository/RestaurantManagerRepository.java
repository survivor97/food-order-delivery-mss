package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.RestaurantManager;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantManagerRepository extends CrudRepository<RestaurantManager, Long> {
    List<RestaurantManager> findAll();
    RestaurantManager findByUsername(String username);
}
