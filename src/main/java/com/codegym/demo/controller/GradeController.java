package com.codegym.demo.controller;


import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Grade;
//import com.codegym.demo.repository.IGradeRepository;
import com.codegym.demo.model.Users;
import com.codegym.demo.service.grade.IGradeService;
import com.codegym.demo.service.subject.ISubjectService;
import com.codegym.demo.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "*")
public class GradeController {
    @Autowired
    private IGradeService gradeService;
    @Autowired
    private ISubjectService subjectService;
    @Autowired
    private IUsersService usersService;


    @GetMapping("")
    public ResponseEntity<?> showList(){

        return new ResponseEntity<>(gradeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createGrade(@RequestBody Grade grade) {
        grade.setSubject(subjectService.findById(grade.getSubject_id()).get());
        grade.setUsers(usersService.findById(grade.getUsers_id()).get());
        gradeService.save(grade);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteGrade(@PathVariable Long id){
        Optional<Grade> grade = gradeService.findById(id);

        if (!grade.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        gradeService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateGrade(@PathVariable Long id, @RequestBody Grade grade){

        Optional<Grade> grade1 = gradeService.findById(id);
        if(!grade1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        grade1.get().setExam(grade.getExam());
        grade1.get().setTheory(grade.getTheory());
        grade1.get().setPractice(grade.getPractice());
        gradeService.save(grade1.get());
        return new ResponseEntity<>(new ResponseMessage("update_success!"), HttpStatus.OK);
    }

    @GetMapping("/findAllByUsersId/{id}")
    public ResponseEntity<Iterable<Grade>> findAllByUsersId(@PathVariable("id") Users users ){
        return new ResponseEntity<>(gradeService.findAllByUsers(users),HttpStatus.OK);
    }

}