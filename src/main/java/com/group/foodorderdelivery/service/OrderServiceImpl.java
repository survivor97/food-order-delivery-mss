package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.*;
import com.group.foodorderdelivery.repository.FoodRepository;
import com.group.foodorderdelivery.repository.OrderRepository;
import com.group.foodorderdelivery.repository.RestaurantRepository;
import com.group.foodorderdelivery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Order;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private UserRepository userRepository;
    private RestaurantRepository restaurantRepository;
    private FoodRepository foodRepository;

    Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl(OrderRepository orderRepository,
                            UserRepository userRepository,
                            RestaurantRepository restaurantRepository,
                            FoodRepository foodRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.restaurantRepository = restaurantRepository;
        this.foodRepository = foodRepository;
    }

    @Override
    public List<Orders> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public List<Orders> findByUserId(Long id) {
        return orderRepository.findByUserId(id);
    }

    @Override
    public List<Orders> findByDeliveryUserId(Long id) {
        return orderRepository.findByDeliveryUserId(id);
    }

    @Override
    public Orders newOrder(Long userId, Long restaurantId, List<Food> foodList) {
        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()) {
            LOGGER.info("User not found!");
            return null;
        }

        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if(!restaurant.isPresent()) {
            LOGGER.info("Restaurant not found!");
            return null;
        }

        if(foodList.size() == 0) {
            LOGGER.info("Order's food list is empty!");
            return null;
        }

        Orders order = new Orders();
        order.setUser(user.get());
        order.setRestaurant(restaurant.get());

        List<Food> filteredFoodList = new ArrayList<>();

        for(int i=0; i<foodList.size(); i++) {
            Optional<Food> food = foodRepository.findById(foodList.get(i).getId());
            if(!food.isPresent()) {
                LOGGER.info("Food at position {" + i + "} not found!");
                return null;
            }
            filteredFoodList.add(food.get());
        }

        order.setFoodList(filteredFoodList);
        order.setOrderDateTime(LocalDateTime.now());
        order.setOrderStatus(OrderStatus.RECEIVED);

        orderRepository.save(order);
        return order;
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public Orders setOrderStatus(Long orderId, OrderStatus orderStatus) {
        Optional<Orders> order = orderRepository.findById(orderId);
        if(!order.isPresent()) {
            LOGGER.info("Order with id {" + orderId + "} not found!");
            return null;
        }

        order.get().setOrderStatus(orderStatus);
        orderRepository.save(order.get());
        return order.get();
    }

}
