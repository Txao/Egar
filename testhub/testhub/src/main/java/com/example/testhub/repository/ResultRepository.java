package com.example.testhub.repository;

import com.example.testhub.domain.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result, Long> {
    List<Result> findAll();

    Result findByUsername(String username);
}
