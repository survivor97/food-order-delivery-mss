package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();
    User findByUsername(String username);

}
