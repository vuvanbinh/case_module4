package com.codegym.demo.repository;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Long> {
    Boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);

    Boolean existsByEmailAndPassword (String email,String password);

    @Query(value = "select u from Users u " +
            "join Classes c on u.id = c.id " +
            "join Role r on  r.id=u.id" +
            " where c.id = ?1 and r.name='STUDENT' ")
    Iterable<Users> findAllByClassId(Long id);



    Iterable<Users> findAllByClasses(Classes  classes );

    @Query(value = "SELECT u FROM Users u " +
            "Join Classes c ON u.id = c.id " +
            "JOIN Role r ON r.id=u.id" +
            " WHERE c.id = ?1 and r.name= 'COACH' ")
    Iterable<Users> findAllCoachByClassId(Long id);

}