package com.example.testhub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass

@NoArgsConstructor
@AllArgsConstructor
@Getter
public abstract class Question {
    @Id
    @Column(name = "id_question")
    private Long id;

    private String question;
    private String answer;

    @Column(name = "w_answer_1")
    private String wAnswer1;
    @Column(name = "w_answer_2")
    private String wAnswer2;
    @Column(name = "w_answer_3")
    private String wAnswer3;
}
