package com.example.testhub.controller;

import com.example.testhub.domain.Result;
import com.example.testhub.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/results")
public class ResultController {
    private ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping()
    public String resultsForm(Model model) {
        List<Result> listOfResults = this.resultService.getAll();
        model.addAttribute("results", listOfResults);

        return "results";
    }
}
