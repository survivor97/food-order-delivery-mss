package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.DeliveryUser;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryUserRepository extends CrudRepository<DeliveryUser, Long> {
    List<DeliveryUser> findAll();
    DeliveryUser findByUsername(String username);
    Optional<DeliveryUser> findById(Long id);
}
