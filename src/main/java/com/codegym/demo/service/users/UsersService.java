package com.codegym.demo.service.users;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Role;
import com.codegym.demo.model.Users;
import com.codegym.demo.repository.IClassesRepository;
import com.codegym.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService implements IUsersService{

    @Autowired
    IUsersRepository usersRepository;

    @Autowired
    IClassesRepository classesRepository;


    @Override
    public Boolean existsByEmail(String email) {
        return usersRepository.existsByEmail(email);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return usersRepository.findByEmail(email);
    }

//    @Override
//    public Iterable<Users> findAllStudentByClassId(Long id) {
//        Classes c = classesRepository.getById(id);
//        return usersRepository.findAllByClasses(c);
//    }

    @Override
    public Iterable<Users> findAllStudentByClassId(Long id) {
        return usersRepository.findAllByClassId(id);
    }


//    @Override
    public Iterable<Users> findAllMinistryByClassId(Long id) {
        return findAllMinistryByClassId(id);
    }


//    @Override
//    public Iterable<Users> findAllByAClass_Id(Long id) {
//        Classes classes = classesRepository.getById(id);
//        return usersRepository.findAllByAClass(classes);
//    }




    @Override
    public Iterable<Users> findAll() {
       return usersRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public void save(Users users) {
        usersRepository.save(users);
    }

    @Override
    public void remove(Long id) {
        usersRepository.deleteById(id);
    }
















    //    @Override
//    public Boolean checkLogin(String email, String password) {
//        List<Users> usersList = (List<Users>) findAll();
//        for (Users u: usersList
//        ) {
//            if (u.getEmail().equals(email) && u.getPassword().equals(password)){
//                return true;
//            }
//        }
//        return false;
//    }

}
