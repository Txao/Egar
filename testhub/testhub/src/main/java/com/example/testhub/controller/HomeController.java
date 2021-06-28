package com.example.testhub.controller;

import com.example.testhub.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {
    private TestService testService;

    @Autowired
    public HomeController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("tests", this.testService.findAll());
        return "home";
    }

}
