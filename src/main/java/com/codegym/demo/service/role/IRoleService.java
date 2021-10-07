package com.codegym.demo.service.role;

import com.codegym.demo.model.Role;
import com.codegym.demo.model.RoleName;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findByName(RoleName name);
}
