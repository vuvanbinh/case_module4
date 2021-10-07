package com.codegym.demo.service;

import java.util.Optional;

public interface IService <B>{
    Iterable<B> findAll();
    Optional<B> findById(Long id);
    void save(B b);
    void remove(Long id);
}
