package com.codegym.demo.controller;

import com.codegym.demo.dto.response.ResponseMessage;
import com.codegym.demo.model.TuitionFee;
import com.codegym.demo.service.tuitionfee.ITuitionFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tuitionfee")
@CrossOrigin(origins = "*")
public class TuititonFeeController {

    @Autowired
    ITuitionFeeService tuitionFeeService;

    @GetMapping("")
    public ResponseEntity<?> listTuitionFee() {
        List<TuitionFee> tuitionfee = (List<TuitionFee>) tuitionFeeService.findAll();
        if (tuitionfee.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tuitionfee, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createTuitionFee(@RequestBody TuitionFee tuitionfee) {
        if (tuitionfee.getStatus().trim().isEmpty()) {
            return new ResponseEntity<>(new ResponseMessage("The Status is required!"), HttpStatus.OK);
        }
        tuitionFeeService.save(tuitionfee);
        return new ResponseEntity<>(new ResponseMessage("Create TuitionFee success!"), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> updateTuitionFee(@PathVariable Long id, @RequestBody TuitionFee tuitionfee) {
        Optional<TuitionFee> tuitionFee1 = tuitionFeeService.findById(id);

        if (!tuitionFee1.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuitionFee1.get().setDotDog(tuitionfee.getDotDog());
        tuitionFee1.get().setMoney(tuitionfee.getMoney());
        tuitionFee1.get().setStatus(tuitionfee.getStatus());
        tuitionFeeService.save(tuitionFee1.get());
        return new ResponseEntity<>(new ResponseMessage("Update success!"), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteTuitionFee(@PathVariable Long id) {
        Optional<TuitionFee> tuitionfee = tuitionFeeService.findById(id);

        if (!tuitionfee.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        tuitionFeeService.remove(id);
        return new ResponseEntity<>(new ResponseMessage("Delete success!"), HttpStatus.OK);
    }

    @GetMapping("detail/{id}")
    public ResponseEntity<?> detailTuitionFee(@PathVariable Long id) {
        Optional<TuitionFee> tuitionFee2 = tuitionFeeService.findById(id);

        if (!tuitionFee2.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(tuitionFee2, HttpStatus.OK);
    }
}
