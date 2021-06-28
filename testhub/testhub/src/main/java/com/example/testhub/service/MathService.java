package com.example.testhub.service;

import com.example.testhub.domain.MathQuestion;
import com.example.testhub.repository.MathRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MathService {
    private MathRepository mathRepository;

    @Autowired
    public MathService(MathRepository mathRepository) {
        this.mathRepository = mathRepository;
    }

    public List<MathQuestion> findAll() {
        return this.mathRepository.findAll();
    }
}
