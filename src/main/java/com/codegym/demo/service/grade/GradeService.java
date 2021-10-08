package com.codegym.demo.service.grade;

import com.codegym.demo.model.Grade;
import com.codegym.demo.repository.IGradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService implements IGradeService{

    @Autowired
    private IGradeRepository gradeRepository;
    @Override
    public Iterable findAll() {
        return gradeRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return gradeRepository.findById(id);
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(Long id) {
        gradeRepository.deleteById(id);

    }

    @Override
    public void save(Grade grade) {
        gradeRepository.save(grade);

    }

}
