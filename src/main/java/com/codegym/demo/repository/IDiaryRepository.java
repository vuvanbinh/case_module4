package com.codegym.demo.repository;

import com.codegym.demo.model.Diary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDiaryRepository extends JpaRepository<Diary,Long> {
}
