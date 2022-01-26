package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Orders;
import com.group.foodorderdelivery.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
}
