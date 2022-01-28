package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.DeliveryUser;

import java.util.List;

public interface DeliveryUserService {
    List<DeliveryUser> findAll();
    DeliveryUser findByUsername(String username);
    void save(DeliveryUser deliveryUser);
}
