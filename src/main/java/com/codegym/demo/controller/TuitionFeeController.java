package com.codegym.demo.controller;

import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.service.tuitionFee.ITuitionFeeService;
import com.codegym.demo.service.users.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tuitionFee")
@CrossOrigin(origins = "*")
public class TuitionFeeController {
    @Autowired
    ITuitionFeeService tuitionFeeService;
    @Autowired
    IUsersService usersService;

    @GetMapping("")
    public ResponseEntity<Iterable<TuitionFee>> findAll(){
        return new ResponseEntity<>(tuitionFeeService.findAll(), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<?>save(@RequestBody TuitionFee tuitionFee){
        Long userId = tuitionFee.getUsersId();
        tuitionFee.setUsers(usersService.findById(userId).get());
        tuitionFeeService.save(tuitionFee);
        return new ResponseEntity<>(new ResponseMessage("Create success!"),HttpStatus.OK);
    }
}
