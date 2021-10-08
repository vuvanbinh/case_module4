package com.codegym.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private int phoneNumber;
    private String address;
    private Date dob;
    private String status;
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "classes_id")
    @JsonBackReference
    private Classes classes;

//    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//    @JoinColumn(name = "tuitionFee_id")
//    private TuitionFee tuitionFee;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "diary_id")
    private Diary diary;

}
