package com.codegym.demo.controller;

import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Diary;
import com.codegym.demo.service.classes.IClassesService;
import com.codegym.demo.service.diary.IDiaryService;
import com.codegym.demo.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/diary")
@CrossOrigin(origins = "*")
public class DiaryController {

    @Autowired
    private IDiaryService diaryService;
    @Autowired
    private IClassesService classesService;
    @Autowired
    private IUsersService usersService;

    @GetMapping("")
    public ResponseEntity<Iterable<Diary>> findAll(){
        return new ResponseEntity<>(diaryService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?> save(@RequestBody Diary diary){
        Long usersId = diary.getUsersId();
        Long classesId = diary.getClassesId();
        if (classesId!=null){
               diary.setClasses(classesService.findById(classesId).get());
        }else {
            diary.setUsers(usersService.findById(usersId).get());
        }
        diaryService.save(diary);
        return new ResponseEntity<>(new ResponseMessage("Create success!"),HttpStatus.OK);
    }

}
