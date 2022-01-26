package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.DeliveryUser;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryUserRepository extends CrudRepository<DeliveryUser, Long> {
    DeliveryUser findByUsername(String username);
}
