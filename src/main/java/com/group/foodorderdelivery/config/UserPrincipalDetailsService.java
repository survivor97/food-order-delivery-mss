package com.group.foodorderdelivery.config;

import com.group.foodorderdelivery.model.Admin;
import com.group.foodorderdelivery.model.DeliveryUser;
import com.group.foodorderdelivery.model.RestaurantManager;
import com.group.foodorderdelivery.model.User;
import com.group.foodorderdelivery.repository.AdminRepository;
import com.group.foodorderdelivery.repository.DeliveryUserRepository;
import com.group.foodorderdelivery.repository.RestaurantManagerRepository;
import com.group.foodorderdelivery.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

    private Logger LOGGER = LoggerFactory.getLogger(UserDetailsService.class);

    private UserRepository userRepository;
    private AdminRepository adminRepository;
    private DeliveryUserRepository deliveryUserRepository;
    private RestaurantManagerRepository restaurantManagerRepository;

    public UserPrincipalDetailsService(UserRepository userRepository,
                                       AdminRepository adminRepository,
                                       DeliveryUserRepository deliveryUserRepository,
                                       RestaurantManagerRepository restaurantManagerRepository) {
        this.userRepository = userRepository;
        this.adminRepository = adminRepository;
        this.deliveryUserRepository = deliveryUserRepository;
        this.restaurantManagerRepository = restaurantManagerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByUsername(username);
        if(admin != null) {
            LOGGER.info("Login - Admin user found!");
            UserPrincipal userPrincipal = new UserPrincipal(admin);
            return userPrincipal;
        }

        RestaurantManager restaurantManager = restaurantManagerRepository.findByUsername(username);
        if(restaurantManager != null) {
            LOGGER.info("Login - Restaurant Manager user found!");
            UserPrincipal userPrincipal = new UserPrincipal(restaurantManager);
            return userPrincipal;
        }

        User user = userRepository.findByUsername(username);
        if(user != null) {
            LOGGER.info("Login - User found!");
            UserPrincipal userPrincipal = new UserPrincipal(user);
            return userPrincipal;
        }

        DeliveryUser deliveryUser = deliveryUserRepository.findByUsername(username);
        if(deliveryUser != null) {
            LOGGER.info("Login - Delivery User found!");
            UserPrincipal userPrincipal = new UserPrincipal(deliveryUser);
            return userPrincipal;
        }

        LOGGER.info("Account not found");
        return null;
    }
}
