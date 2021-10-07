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
    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

}
