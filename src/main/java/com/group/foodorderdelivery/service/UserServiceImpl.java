package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void save(User user) {
        LOGGER.info("Saving user with username {" + user.getUsername() + "} and email {" + user.getEmail() +"}...");
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        LOGGER.info("Getting registered user list...");
        return userRepository.findAll();
    }
}
