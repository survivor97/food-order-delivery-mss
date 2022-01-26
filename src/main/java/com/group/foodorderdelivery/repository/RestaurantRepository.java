package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {

    List<Restaurant> findAll();
    Optional<Restaurant> findById(Long id);
    List<Restaurant> findByNameContaining(String keyword);
    List<Restaurant> findByFoodNameContaining(String keyword);

}
