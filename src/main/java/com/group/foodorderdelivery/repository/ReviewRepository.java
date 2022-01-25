package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Review;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReviewRepository extends CrudRepository<Review, Long> {

    List<Review> findAll();
    List<Review> findReviewByRestaurantId(Long id);

}
