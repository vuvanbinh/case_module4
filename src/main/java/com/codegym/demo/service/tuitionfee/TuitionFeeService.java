package com.codegym.demo.service.tuitionfee;

import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.repository.ITuitionFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TuitionFeeService implements ITuitionFeeService {
    @Autowired
    ITuitionFeeRepository tuitionFeeRepository;

    @Override
    public Iterable<TuitionFee> findAll() {
        return tuitionFeeRepository.findAll();
    }

    @Override
    public Optional<TuitionFee> findById(Long id) {
        return tuitionFeeRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        tuitionFeeRepository.deleteById(id);
    }

    @Override
    public void save(TuitionFee tuitionfee) {
        tuitionFeeRepository.save(tuitionfee);
    }
}
