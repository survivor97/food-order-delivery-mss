package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.DeliveryUser;
import com.group.foodorderdelivery.repository.DeliveryUserRepository;

public class DeliveryUserServiceImpl implements DeliveryUserService {

    private DeliveryUserRepository deliveryUserRepository;

    public DeliveryUserServiceImpl(DeliveryUserRepository deliveryUserRepository) {
        this.deliveryUserRepository = deliveryUserRepository;
    }

    @Override
    public DeliveryUser findByUsername(String username) {
        return deliveryUserRepository.findByUsername(username);
    }
}
