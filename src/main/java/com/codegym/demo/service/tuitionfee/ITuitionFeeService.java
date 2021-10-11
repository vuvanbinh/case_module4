package com.codegym.demo.service.tuitionfee;

import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.service.IService;

public interface ITuitionFeeService extends IService<TuitionFee> {
    void save(TuitionFee tuitionfee);
}
