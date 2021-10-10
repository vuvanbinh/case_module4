package com.codegym.demo.model;

import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tuitionFees")
@Data
public class TuitionFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dotDog;
    private Date dayDog;
    private int money;
    private String status;
    @Transient
    private Long usersId;
    @ManyToOne
    private Users users;

}
