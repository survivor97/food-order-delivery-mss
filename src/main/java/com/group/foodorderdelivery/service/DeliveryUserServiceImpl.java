package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.DeliveryUser;
import com.group.foodorderdelivery.repository.DeliveryUserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryUserServiceImpl implements DeliveryUserService {

    private DeliveryUserRepository deliveryUserRepository;

    private PasswordEncoder passwordEncoder;

    Logger LOGGER = LoggerFactory.getLogger(DeliveryUserServiceImpl.class);

    public DeliveryUserServiceImpl(DeliveryUserRepository deliveryUserRepository, PasswordEncoder passwordEncoder) {
        this.deliveryUserRepository = deliveryUserRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<DeliveryUser> findAll() {
        return deliveryUserRepository.findAll();
    }

    @Override
    public DeliveryUser findByUsername(String username) {
        return deliveryUserRepository.findByUsername(username);
    }

    @Override
    public void save(DeliveryUser deliveryUser) {
        LOGGER.info("Saving delivery user with username {" + deliveryUser.getUsername() + "} and email {" + deliveryUser.getEmail() +"}...");
        deliveryUser.setPassword(passwordEncoder.encode(deliveryUser.getPassword()));
        deliveryUserRepository.save(deliveryUser);
    }

}
