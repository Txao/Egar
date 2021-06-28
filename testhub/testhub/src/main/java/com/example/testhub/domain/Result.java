package com.example.testhub.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "results")

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;

    @Column(name = "math_score")
    private Integer mathScore = 0;

    @Column(name = "iq_score")
    private Integer iqScore = 0;

    @Column(name = "prog_score")
    private Integer progScore = 0;

    public int getTotalScore() {
        return (this.mathScore + this.iqScore + this.progScore);
    }
}
