package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.DeliveryUser;
import com.group.foodorderdelivery.service.DeliveryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryUserController {

    @Autowired
    private DeliveryUserService deliveryUserService;

    @PostMapping("/registerDeliveryUser")
    public ResponseEntity<?> insertUser(@RequestBody DeliveryUser deliveryUser) {
        deliveryUserService.save(deliveryUser);
        return ResponseEntity.ok().body(deliveryUser.getId());
    }

    @GetMapping("/deliveryUsers/all")
    public List<DeliveryUser> getAllDeliveryUsers() {
        return deliveryUserService.findAll();
    }

}
