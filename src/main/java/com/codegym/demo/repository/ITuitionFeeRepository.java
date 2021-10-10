package com.codegym.demo.repository;

import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface ITuitionFeeRepository extends JpaRepository<TuitionFee,Long> {
    Iterable<TuitionFee> findAllByUsers(Users users);
}
