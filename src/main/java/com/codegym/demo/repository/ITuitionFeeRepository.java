package com.codegym.demo.repository;

import com.codegym.demo.model.TuitionFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITuitionFeeRepository extends JpaRepository<TuitionFee,Long> {
}
