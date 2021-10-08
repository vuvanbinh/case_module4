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

    public JwtResponse(String token, String fullName, String avatar, Collection<? extends GrantedAuthority> authorities) {
    }

    public JwtResponse(String token, String type, String fullName, String avatar, Collection<? extends GrantedAuthority> roles) {
        this.token = token;
        this.type = type;
        this.fullName = fullName;
        this.avatar = avatar;
        this.roles = roles;
    }
}