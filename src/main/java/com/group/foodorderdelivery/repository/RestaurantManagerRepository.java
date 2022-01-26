package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.RestaurantManager;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantManagerRepository extends CrudRepository<RestaurantManager, Long> {
    RestaurantManager findByUsername(String username);
}
