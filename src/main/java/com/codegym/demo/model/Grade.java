package com.codegym.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "grades")
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String exam;
    private int theory;
    private int practice;
    private double average;
    @Transient
    private Long subject_id;
    @Transient
    private Long users_id;
    @ManyToOne
    private Subject subject;
    @ManyToOne
    private Users users;

}
