package com.group.foodorderdelivery.controller;

import com.group.foodorderdelivery.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = "/login")
    private String getRole() {
        return loginService.getCurrentUserRole();
    }

}
