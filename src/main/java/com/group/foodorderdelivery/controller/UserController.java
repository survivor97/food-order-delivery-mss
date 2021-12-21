package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.*;
import com.group.foodorderdelivery.service.UserService;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> insertUser(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok().body(user.getId());
    }

    @GetMapping("/users/all")
    public List<User> getUsers() {
        return userService.findAll();
    }

}
