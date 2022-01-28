package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Admin;
import com.group.foodorderdelivery.repository.AdminRepository;

public class AdminServiceImpl implements AdminService {

    private AdminRepository adminRepository;

    public AdminServiceImpl(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findByUsername(String username) {
        return adminRepository.findByUsername(username);
    }
}
