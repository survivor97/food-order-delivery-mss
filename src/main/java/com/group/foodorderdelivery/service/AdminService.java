package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Admin;

public interface AdminService {
    Admin findByUsername(String username);
}
