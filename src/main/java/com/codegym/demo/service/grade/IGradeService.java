package com.codegym.demo.service.grade;

import com.codegym.demo.model.Grade;
import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.model.Users;
import com.codegym.demo.service.IService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface IGradeService extends IService<Grade> {
    Iterable<Grade> findAllByUsers(Users users);
}
