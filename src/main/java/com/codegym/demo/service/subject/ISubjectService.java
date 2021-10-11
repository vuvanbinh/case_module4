package com.codegym.demo.service.subject;

import com.codegym.demo.model.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService {
    Optional<Subject> findById(Long id);
    List<Subject> findAll();
    Subject save(Subject subject);
    void deleteById(Long id);
}
