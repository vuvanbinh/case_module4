package com.codegym.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "subjects")
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
