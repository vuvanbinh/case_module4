package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;

import java.util.Optional;

public class ClassesService implements IClassesService {
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
}
