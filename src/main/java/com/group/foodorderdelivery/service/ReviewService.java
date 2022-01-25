package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Review;

import java.util.List;

public interface ReviewService {

    List<Review> findAll();
    List<Review> findReviewByRestaurantId(Long id);

}
