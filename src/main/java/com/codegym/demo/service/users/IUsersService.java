package com.codegym.demo.service.users;

import com.codegym.demo.model.Users;
import com.codegym.demo.service.IService;

import java.util.List;
import java.util.Optional;

public interface IUsersService extends IService<Users> {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);

    List<Users> finAllByRoleName(String roleName);
    public List<Users> finAllByClassesId(Long id);

    Iterable<Users> findAllByStatus(String status);

}
