package com.codegym.demo.service.diary;

import com.codegym.demo.model.Diary;
import com.codegym.demo.model.Grade;
import com.codegym.demo.service.IService;

public interface IDiaryService extends IService {

    void save(Diary diary);
}
