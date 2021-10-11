package com.codegym.demo.service.classes;

import com.codegym.demo.model.Classes;

import java.util.Optional;

import com.codegym.demo.model.Users;
import com.codegym.demo.repository.IClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        public Iterable<Classes> findAllByUsers(Users users) {
            return classesRepository.findAllByUsers(users);
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
        public Boolean existsByName(String name) {
            return classesRepository.existsByName(name);
        }
    }

