package com.codegym.demo.model;

import lombok.Data;

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
    private Date dob;
    private String status;
    private String avatar;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();
//    @ManyToOne
//    @JoinColumn(name = "classes_id")
//    private Classes aClass;
//    @ManyToOne
//    @JoinColumn(name = "tuitionFee_id")
//    private TuitionFee tuitionFee;
//    @ManyToOne
//    @JoinColumn(name = "diary_id")
//    private Diary diary;
}
