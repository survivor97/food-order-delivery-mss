package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.model.*;
import com.group.foodorderdelivery.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registerUser")
    public ResponseEntity<?> insertUser(@RequestBody User user) {
        user.setRole(Role.USER);
        userService.save(user);
        return ResponseEntity.ok().body(user.getId());
    }

    @GetMapping("/users/all")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }

}
