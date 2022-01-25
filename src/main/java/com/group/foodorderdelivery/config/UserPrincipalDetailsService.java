package com.group.foodorderdelivery.config;

import com.group.foodorderdelivery.model.User;
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

    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user == null) {
            LOGGER.info("User not found");
            return  null;
        }
        UserPrincipal userPrincipal = new UserPrincipal(user);
        return userPrincipal;
    }
}
