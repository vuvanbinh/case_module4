package com.codegym.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "diaries")
@Data
public class Diary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Date date;
    private String coachName;

    @Transient
    private Long classesId;
    @Transient
    private Long usersId;

    @ManyToOne
    private Classes classes;
    @ManyToOne
    private Users users;


}
