package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Orders;
import com.group.foodorderdelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "/orders/all")
    public List<Orders> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping(value = "/orders", params = "userId")
    public List<Orders> getAllOrdersByUserId(@RequestParam Long userId) {
        return orderService.findByUserId(userId);
    }

    @GetMapping(value = "/orders", params = "deliveryUserId")
    public List<Orders> getAllOrdersByDeliveryUserId(@RequestParam Long deliveryUserId) {
        return orderService.findByDeliveryUserId(deliveryUserId);
    }
}
