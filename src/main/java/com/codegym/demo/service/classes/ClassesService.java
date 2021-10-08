package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
<<<<<<< HEAD

import java.util.Optional;

public class ClassesService implements IClassesService {
=======
import com.codegym.demo.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService{

    @Autowired
    private IClassesRepository classesRepository;

>>>>>>> e36ecd064823506f068b24dc5072379df6eacaa4
    @Override
    public Iterable<Classes> findAll() {
        return classesRepository.findAll() ;
    }

    @Override
    public Optional<Classes> findById(Long id) {
        return classesRepository.findById(id);
    }

    @Override
    public void save(Classes classes) {
        classesRepository.save(classes);

    }

    @Override
    public void remove(Long id) {
        classesRepository.deleteById(id);

    }
<<<<<<< HEAD
=======

    @Override

    public Iterable<Classes> findClassByEmail(String email) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return classesRepository.findAllByName(name);
    }
>>>>>>> e36ecd064823506f068b24dc5072379df6eacaa4
}
