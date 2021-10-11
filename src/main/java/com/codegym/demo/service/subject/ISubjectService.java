package com.codegym.demo.service.subject;

import com.codegym.demo.model.Subject;

import java.util.List;
import java.util.Optional;

public interface ISubjectService extends IService<Subject> {
    Boolean existsByName(String name);
}
