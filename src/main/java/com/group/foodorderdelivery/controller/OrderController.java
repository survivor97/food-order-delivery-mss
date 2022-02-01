package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.Food;
import com.group.foodorderdelivery.model.OrderStatus;
import com.group.foodorderdelivery.model.Orders;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
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

    @PostMapping(value = "/orders/new")
    public ResponseEntity<?> newOrder(@RequestParam Long userId, @RequestParam Long restaurantId, @RequestBody List<Food> foodList) {
        Orders order = orderService.newOrder(userId, restaurantId, foodList);
        if(order != null) {
            return ResponseEntity.ok().body(order.getId());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problems in the post request!");
    }

    @PostMapping(value = "orders/setStatus")
    public ResponseEntity<?> setOrderStatus(@RequestParam Long orderId, @RequestParam OrderStatus orderStatus) {
        Orders order = orderService.setOrderStatus(orderId, orderStatus);
        if(order != null) {
            return ResponseEntity.ok().body(order.getId());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problems in the post request!");
    }

    @PostMapping(value = "orders/setDeliveryUser")
    public ResponseEntity<?> setDeliveryUser(@RequestParam Long orderId, @RequestParam Long deliveryUserId) {
        Orders order = orderService.setDeliveryUser(orderId, deliveryUserId);
        if(order != null) {
            return ResponseEntity.ok().body(order.getId());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problems in the post request!");
    }
}
