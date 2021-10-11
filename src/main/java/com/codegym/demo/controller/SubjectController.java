package com.codegym.demo.controller;

import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.Subject;
import com.codegym.demo.service.subject.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
@CrossOrigin(origins = "*")
public class SubjectController {
    @Autowired
    ISubjectService subjectService;

    @GetMapping("")
    public ResponseEntity<?> listSubject() {
        List<Subject> subjects = subjectService.findAll();
        if (subjects.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<?> createSubject(@RequestBody Subject subject) {
        if (subject.getName().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The name is required!"), HttpStatus.OK);
        }
        subjectService.save(subject);
        return new ResponseEntity<>(new ResponseMessage("Create subject success!"), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        Optional<Subject> subject1 = subjectService.findById(id);

        if (!subject1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (subject.getName().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The name is required"), HttpStatus.OK);
        }
        subject1.get().setName(subject.getName());
        subjectService.save(subject1.get());
        return new ResponseEntity<>(new ResponseMessage("Update success!"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detailSubject(@PathVariable Long id) {
        Optional<Subject> subject2 = subjectService.findById(id);

        if (!subject2.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subject2, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSubject(@PathVariable Long id){
        Optional<Subject> subject = subjectService.findById(id);

        if (!subject.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        subjectService.deleteById(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success!"), HttpStatus.OK);
    }
}
