package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public class ClassesService implements IClassesService{
    @Override
    public Iterable<Classes> findAll() {
        return null;
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Classes classes) {

    }

    @Override
    public void remove(Long id) {

    }

    @Override

    public Iterable<Classes> findClassByEmail(String email) {
        return null;
    }
}
