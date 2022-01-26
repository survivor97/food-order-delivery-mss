package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.DeliveryUser;

public interface DeliveryUserService {
    DeliveryUser findByUsername(String username);
}
