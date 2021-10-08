package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
import com.codegym.demo.service.IService;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface IClassesService extends IService<Classes> {

    Iterable<Classes> findClassByEmail(String email);

    boolean existsByName(String name);
}
