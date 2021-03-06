package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.User;

import java.util.List;

public interface UserService {

    void save(User user);
    List<User> findAll();
    User findByUsername(String username);

}
