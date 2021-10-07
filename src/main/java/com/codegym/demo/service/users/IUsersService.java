package com.codegym.demo.service.users;

import com.codegym.demo.model.Users;

import java.util.Optional;

public interface IUsersService {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
    Users save(Users users);
}
