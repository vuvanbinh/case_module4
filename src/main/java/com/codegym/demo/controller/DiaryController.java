package com.codegym.demo.controller;


import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Diary;
import com.codegym.demo.model.Grade;
import com.codegym.demo.service.diary.IDiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/diary")
@CrossOrigin(origins = "*")
public class DiaryController {

    @Autowired
    private IDiaryService diaryService;

    @GetMapping("")
    public ResponseEntity<?> showList(){

        return new ResponseEntity<>(diaryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGrade(@RequestBody Diary diary) {
        if (diary.getContent().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The content is required!"), HttpStatus.OK);
        }diaryService.save(diary);
        return new ResponseEntity<>(new ResponseMessage("Create diary success!"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable Long id){
        Optional<Diary> diary = diaryService.findById(id);

        if (!diary.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        diaryService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Delete  diary success!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGrade(@PathVariable Long id, @RequestBody Diary diary){
        Optional<Diary> diary1 = diaryService.findById(id);
        if(!diary1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        diary1.get().setContent(diary.getContent());
        diary1.get().setDate(diary.getDate());
        diaryService.save(diary1.get());
        return new ResponseEntity<>(new ResponseMessage("update diary success!"), HttpStatus.OK);
    }
}
