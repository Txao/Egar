package com.example.testhub.repository;

import com.example.testhub.domain.MathQuestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MathRepository extends JpaRepository<MathQuestion, Long> {
    List<MathQuestion> findAll();
}
