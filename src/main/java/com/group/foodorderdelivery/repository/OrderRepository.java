package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Orders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Orders, Long> {

    List<Orders> findAll();
    List<Orders> findByUserId(Long id);
    List<Orders> findByDeliveryUserId(Long id);
    Optional<Orders> findById(Long id);

}
