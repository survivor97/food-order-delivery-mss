package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Review;
import com.group.foodorderdelivery.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    ReviewRepository reviewRepository;

    public ReviewServiceImpl(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return reviewRepository.findAll();
    }

    @Override
    public List<Review> findReviewByRestaurantId(Long id) {
        return reviewRepository.findReviewByRestaurantId(id);
    }

}
