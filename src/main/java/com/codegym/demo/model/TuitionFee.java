package com.codegym.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "tuitionFees")
@Data
public class TuitionFee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dotDog;
    private double money;
    private String status;
    @OneToOne
    private Users users;
//hello
}
