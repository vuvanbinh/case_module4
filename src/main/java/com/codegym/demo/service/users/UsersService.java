package com.codegym.demo.service.users;

import com.codegym.demo.model.Users;
import com.codegym.demo.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersService implements IUsersService{

    @Autowired
    IUsersRepository appUserRepository;


    @Override
    public Boolean existsByEmail(String email) {
        return appUserRepository.existsByEmail(email);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        return appUserRepository.findByEmail(email);
    }

    @Override
    public Users save(Users users) {
        return appUserRepository.save(users);
    }

}
