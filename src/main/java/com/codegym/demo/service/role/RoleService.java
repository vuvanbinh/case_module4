package com.codegym.demo.service.role;

import com.codegym.demo.repository.IRoleRepository;
import com.codegym.demo.model.Role;
import com.codegym.demo.model.RoleName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService{

    @Autowired
    IRoleRepository roleRepository;

    @Override
    public Optional<Role> findByName(RoleName name) {
        return roleRepository.findByName(name);
    }
}
