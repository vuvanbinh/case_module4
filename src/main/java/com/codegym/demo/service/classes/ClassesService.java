package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;
import com.codegym.demo.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClassesService implements IClassesService{

    @Autowired
    private IClassesRepository classesRepository;

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

    @Override

    public Iterable<Classes> findClassByEmail(String email) {
        return null;
    }

    @Override
    public boolean existsByName(String name) {
        return classesRepository.findAllByName(name);
    }
}
