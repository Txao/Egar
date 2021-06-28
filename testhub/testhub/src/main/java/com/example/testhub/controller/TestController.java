package com.example.testhub.controller;

import com.example.testhub.Tools.TestTools;
import com.example.testhub.domain.Result;
import com.example.testhub.service.MathService;
import com.example.testhub.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    private MathService mathService;
    private ResultService resultService;

    @Autowired
    public TestController(MathService mathService, ResultService resultService) {
        this.mathService = mathService;
        this.resultService = resultService;
    }

    @GetMapping("/math")
    public String mathTestForm(Model model) {
        model.addAttribute("questions", this.mathService.findAll());
        return "math";
    }

    @PostMapping("/math")
    public String mathTestAnswers(@RequestParam(value = "answers") String answers,
                                  @RequestParam(value = "username") String username) {

        List<String> listOfAnswers = TestTools.delimeter(answers);
        int mathResult = TestTools.compareAnswers(listOfAnswers, this.mathService);

        Result newResult = new Result();
        newResult.setUsername(username);
        newResult.setMathScore(mathResult);

        this.resultService.addResult(newResult);

        return "redirect:/results";
    }
}
