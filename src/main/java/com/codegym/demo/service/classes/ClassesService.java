package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;

import java.util.Optional;

public class ClassesService implements IClassesService {
import com.codegym.demo.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Optional;

    @Service
    public class ClassesService implements IClassesService {

        @Autowired
        IClassesRepository classesRepository;

        @Override
        public Iterable<Classes> findAll() {
            return classesRepository.findAll();
        }

        @Override
        public Optional<Classes> findById(Long id) {
            return classesRepository.findById(id);
        }

        @Override
        public void save(Classes classes) {

        }

        @Override
        public void remove(Long id) {

        }
    }
}
