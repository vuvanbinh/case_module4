package com.codegym.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@Data
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;
}
