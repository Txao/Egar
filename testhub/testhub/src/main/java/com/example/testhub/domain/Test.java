package com.example.testhub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tests")

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Test {
    @Id
    @Column(name = "id_test")
    private Long id;

    @Column(name = "test_name")
    private String testName;
}
