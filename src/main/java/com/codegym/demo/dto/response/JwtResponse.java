package com.codegym.demo.dto.response;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Data
public class JwtResponse {
    String token;
    private String type = "Bearer";
    private String fullName;
    private String avatar;
    private Collection<? extends GrantedAuthority> roles;

}