package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Users;
import com.codegym.demo.service.IService;

public interface IClassesService extends IService<Classes> {
    Boolean existsByName(String name);
    Iterable<Classes> findAllByUsers(Users users);
}
