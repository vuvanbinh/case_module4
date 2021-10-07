package com.codegym.demo.dto.request;

import lombok.Data;

import java.util.Set;

@Data
public class SignUpForm {

    private String fullName;
    private String email;
    private String password;
    private String avatar;
    Set<String> roles;

}
