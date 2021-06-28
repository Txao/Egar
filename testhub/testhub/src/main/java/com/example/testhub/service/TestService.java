package com.example.testhub.service;

import com.example.testhub.domain.Test;
import com.example.testhub.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService {
    private TestRepository testRepository;

    @Autowired
    public TestService(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> findAll() {
        return this.testRepository.findAll();
    }
}
