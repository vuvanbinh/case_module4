package com.codegym.demo.dto.request;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.TuitionFee;
import lombok.Data;

import java.util.Date;
import java.util.Set;

@Data
public class SignUpForm {

    private String fullName;
    private String email;
    private String password;
    private int phoneNumber;
    private String address;
    private Date dob;
    private String status;
    private String avatar;
    Set<String> roles;
    private Long classesId;
    private TuitionFee tuitionFee;
}
