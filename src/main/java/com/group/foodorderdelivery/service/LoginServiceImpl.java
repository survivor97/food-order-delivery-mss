package com.group.foodorderdelivery.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String getCurrentUserRole() {
        List<GrantedAuthority> authorities;

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        authorities = (List<GrantedAuthority>) ((UserDetails)principal).getAuthorities();

        String role = authorities.get(0).toString();
        return authorities.get(0).toString().substring(5, role.length());
    }
}
