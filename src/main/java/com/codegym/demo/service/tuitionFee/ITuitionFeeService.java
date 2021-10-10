package com.codegym.demo.service.tuitionFee;

import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.model.Users;
import com.codegym.demo.service.IService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ITuitionFeeService extends IService<TuitionFee> {
    Iterable<TuitionFee> findAllByUsers(Users users);
}
