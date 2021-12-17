package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}
