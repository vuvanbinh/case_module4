package com.codegym.demo.repository;

import com.codegym.demo.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClassesRepository extends JpaRepository<Classes,Long> {
    Iterable<Classes> findAllByName( Classes name);

    boolean findAllByName(String name);
}
