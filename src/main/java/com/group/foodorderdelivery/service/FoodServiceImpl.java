package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Food;
import com.group.foodorderdelivery.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    private FoodRepository foodRepository;

    @Autowired
    public FoodServiceImpl(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Food> findByRestaurantId(Long id) {
        return foodRepository.findByRestaurantId(id);
    }
}
