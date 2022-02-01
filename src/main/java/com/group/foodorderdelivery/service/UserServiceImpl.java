package com.group.foodorderdelivery.service;

import com.group.foodorderdelivery.model.Restaurant;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void save(User user) {
        LOGGER.info("Saving user with username {" + user.getUsername() + "} and email {" + user.getEmail() +"}...");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        LOGGER.info("Getting registered user list...");
        return userRepository.findAll();
    }

    @Override
    public User findByUsername(String username) {
        LOGGER.info("Getting user by username...");
        return findByUsername(username);
    }

    @Override
    public Optional<User> findById(Long id) {
        LOGGER.info("Getting user by id...");
        return userRepository.findById(id);
    }

    @Override
    public User getCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<GrantedAuthority> authorities = (List<GrantedAuthority>) ((UserDetails) principal).getAuthorities();
        String username = ((UserDetails)principal).getUsername();
        String role = authorities.get(0).toString();
        User user = userRepository.findByUsername(username);
        return user;
    }
}
