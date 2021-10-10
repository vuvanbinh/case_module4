package com.codegym.demo.repository;

import com.codegym.demo.model.Grade;
import com.codegym.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IGrandeRepository extends JpaRepository<Grade,Long> {
    Iterable<Grade> findAllByUsers(Users users);
}
