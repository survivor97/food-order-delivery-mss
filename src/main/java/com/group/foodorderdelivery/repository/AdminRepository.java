package com.group.foodorderdelivery.repository;

import com.group.foodorderdelivery.model.Admin;
import org.springframework.data.repository.CrudRepository;

public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByUsername(String username);
}
