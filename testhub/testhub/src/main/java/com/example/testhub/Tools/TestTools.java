package com.example.testhub.Tools;

import com.example.testhub.domain.MathQuestion;
import com.example.testhub.service.MathService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTools {

    public static List<String> delimeter(String answers) {
        List<String> listOfAnswers = new ArrayList<>();

        String[] subStr;
        String delimeter = ",";
        subStr = answers.split(delimeter);

        listOfAnswers.addAll(Arrays.asList(subStr));

        return listOfAnswers;
    }

    // Intentional hardcode (MathService)
    public static int compareAnswers(List<String> listOfAnswers, MathService mathService) {
        int result = 0;

        List<MathQuestion> listOfMathQuestions = mathService.findAll();

        for (int i = 0; i < listOfMathQuestions.size(); i++) {
            if (listOfAnswers.get(i).equals(listOfMathQuestions.get(i).getAnswer()))
                result++;
        }

        return result;
    }

}
