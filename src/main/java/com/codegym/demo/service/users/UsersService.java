package com.codegym.demo.service.users;

import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Role;
import com.codegym.demo.model.RoleName;
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


    @Override
    public Iterable<Users> findAll() {
       return usersRepository.findAll();
    }

    @Override
    public List<Users> finAllByRoleName(String roleName){
        List<Users> users = new ArrayList<>();
        List<Users> usersList = (List<Users>)findAll();
        for (Users u: usersList
             ) {
            u.getRoles().forEach(role -> {
                if (role.getName().name().equals(roleName)){
                    users.add(u);
                }
            });
        }
        return users;
    }


    public List<Users> finAllByClassesId(Long id){
        List<Users> users = new ArrayList<>();
        List<Users> usersList = finAllByRoleName("STUDENT");
        for (Users u: usersList
             ) {
            if (u.getClasses().getId()==id){
                users.add(u);
            }
        }
        return users;
    }

    @Override
    public Iterable<Users> findAllByStatus(String status) {
        return usersRepository.findAllByStatus(status);
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

}
