package com.codegym.demo.dto.request;

import lombok.Data;

@Data
public class SignInForm {
    private String email;
    private String password;
}