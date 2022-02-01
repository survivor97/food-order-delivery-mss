package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.DeliveryUser;
import com.group.foodorderdelivery.model.Role;
import com.group.foodorderdelivery.service.DeliveryUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class DeliveryUserController {

    @Autowired
    private DeliveryUserService deliveryUserService;

    @PostMapping("/registerDeliveryUser")
    public ResponseEntity<?> insertUser(@RequestBody DeliveryUser deliveryUser) {
        deliveryUser.setRole(Role.DELIVERY_USER);
        deliveryUserService.save(deliveryUser);
        return ResponseEntity.ok().body(deliveryUser.getId());
    }

    @GetMapping("/deliveryUsers/all")
    public List<DeliveryUser> getAllDeliveryUsers() {
        return deliveryUserService.findAll();
    }

}
