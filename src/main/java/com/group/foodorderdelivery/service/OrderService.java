package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Orders;

import java.util.List;

public interface OrderService {

    List<Orders> findAll();
    List<Orders> findByUserId(Long id);
    List<Orders> findByDeliveryUserId(Long id);

}
