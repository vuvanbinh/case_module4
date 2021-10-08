package com.codegym.demo.repository;

import com.codegym.demo.model.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGradeRepository extends JpaRepository<Grade, Long> {


}
