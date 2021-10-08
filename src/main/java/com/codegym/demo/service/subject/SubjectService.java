package com.codegym.demo.service.subject;

import com.codegym.demo.model.Subject;
import com.codegym.demo.repository.ISubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements ISubjectService {
    @Autowired
    ISubjectRepository subjectRepository;

    @Override
    public Iterable<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Long id) {
        return subjectRepository.findById(id);
    }

    @Override
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Override
    public void remove(Long id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return subjectRepository.existsByName(name);
    }
}
