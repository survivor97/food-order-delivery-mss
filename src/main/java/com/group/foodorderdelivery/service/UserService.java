package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);
    List<User> findAll();
    User findByUsername(String username);
    Optional<User> findById(Long id);
    User getCurrentUser();

}
