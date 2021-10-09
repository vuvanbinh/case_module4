package com.codegym.demo.service.diary;

import com.codegym.demo.model.Diary;
import com.codegym.demo.repository.IDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class DiaryService implements IDiaryService{

    @Autowired
    private IDiaryRepository diaryRepository;
    @Override
    public Iterable findAll() {
        return diaryRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return diaryRepository.findById(id);
    }

    @Override
    public void save(Object o) {

    }

    @Override
    public void remove(Long id) {
        diaryRepository.deleteById(id);

    }

    @Override
    public void save(Diary diary) {
        diaryRepository.save(diary);
    }
}
