package com.example.testhub.controller;

import com.example.testhub.domain.Role;
import com.example.testhub.domain.User;
import com.example.testhub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collections;

@Controller
@RequestMapping("/registration")
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registration() {
        return "/registration";
    }

    @PostMapping
    public String addUser(User user) {
        User userFromDb = userService.findByUsername(user.getUsername());

        if (userFromDb != null) {
            return "registration";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userService.save(user);

        return "redirect:/home";
    }
}
