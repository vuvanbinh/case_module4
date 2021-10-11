package com.codegym.demo.repository;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface IClassesRepository extends JpaRepository<Classes,Long> {
    @Query(value = "SELECT c FROM  Classes c Join Users u ON c.id = u.id WHERE u.email = ?1")
    Iterable<Classes> findAllByUsersEmail(String email);
    Boolean existsByName(String name);
    Iterable<Classes> findAllByUsers(Users users);

}
