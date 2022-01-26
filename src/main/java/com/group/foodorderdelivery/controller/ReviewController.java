package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Review;
import com.group.foodorderdelivery.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/reviews/all")
    public List<Review> getAllReviews() {
        return reviewService.findAll();
    }

    @GetMapping(value = "/reviews", params = "restaurantId")
    public List<Review> getAllReviewsByRestaurantId(@RequestParam Long restaurantId) {
        return reviewService.findReviewByRestaurantId(restaurantId);
    }

}
