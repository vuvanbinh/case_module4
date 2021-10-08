package com.codegym.demo.controller;


import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Classes;
import com.codegym.demo.model.Users;
import com.codegym.demo.service.classes.IClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/classes")
@CrossOrigin(origins = "*")
public class ClassesController {
    @Autowired
    private IClassesService classesService;

    @GetMapping("")
    public ResponseEntity<Iterable<Classes>> showList(){
        return new ResponseEntity<>(classesService.findAll(), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<?> createClass(@RequestBody Classes classes) {
        if (classesService.existsByName(classes.getName())) {
            return new ResponseEntity<>(new ResponseMessage("yes"), HttpStatus.OK);
        }
        classesService.save(classes);
        return new ResponseEntity<>(new ResponseMessage("Create success!"), HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteClass(@PathVariable Long id){
        Optional<Classes> classes = classesService.findById(id);

        if (!classes.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classesService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success!"), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateClass(@PathVariable Long id, @RequestBody Classes classes){
        Optional<Classes> classes1 = classesService.findById(id);
        if(!classes1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        classes1.get().setName(classes.getName());
        classesService.save(classes1.get());
        return new ResponseEntity<>(new ResponseMessage("update_success!"), HttpStatus.OK);
    }
    @GetMapping("/findAllByUser/{id}")
    public ResponseEntity<?> findAllByUser(@PathVariable("id") Optional<Users> users){
        return new ResponseEntity<>(classesService.findAllByUsers(users.get()),HttpStatus.OK);
    }

}