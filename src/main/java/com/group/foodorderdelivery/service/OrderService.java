package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Food;
import com.group.foodorderdelivery.model.OrderStatus;
import com.group.foodorderdelivery.model.Orders;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Orders> findAll();
    List<Orders> findByUserId(Long id);
    List<Orders> findByDeliveryUserId(Long id);
    Orders newOrder(Long userId, Long restaurantId, List<Food> foodList);
    Orders setOrderStatus(Long orderId, OrderStatus orderStatus);
    Optional<Orders> findById(Long id);
    Orders setDeliveryUser(Long orderId, Long deliveryUserId);

}
