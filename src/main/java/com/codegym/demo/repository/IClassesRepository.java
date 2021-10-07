package com.codegym.demo.repository;

import com.codegym.demo.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClassesRepository extends JpaRepository<Classes,Long> {
}
