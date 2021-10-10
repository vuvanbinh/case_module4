package com.codegym.demo.service.grade;

import com.codegym.demo.model.Grade;
import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.model.Users;
import com.codegym.demo.repository.IGrandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GradeService implements IGradeService {

    @Autowired
    IGrandeRepository grandeRepository;

    @Override
    public Iterable<Grade> findAll() {
        return grandeRepository.findAll();
    }

    @Override
    public Optional<Grade> findById(Long id) {
        return grandeRepository.findById(id);
    }

    @Override
    public void save(Grade grade) {
        grandeRepository.save(grade);
    }

    @Override
    public void remove(Long id) {
        grandeRepository.deleteById(id);
    }

    @Override
    public Iterable<Grade> findAllByUsers(Users users) {
        return grandeRepository.findAllByUsers(users);
    }
}
