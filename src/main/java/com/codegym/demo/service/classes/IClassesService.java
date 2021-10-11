package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
import com.codegym.demo.service.IService;

public interface IClassesService extends IService<Classes> {

    Iterable<Classes> findClassByEmail(String email);

    boolean existsByName(String name);
}
