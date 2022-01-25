package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    List<Restaurant> findAll();

}
