package com.example.SpringTask10.controller;


import com.example.SpringTask10.DTO.EmployeeDto;
import com.example.SpringTask10.DTO.ResponseDto;
import com.example.SpringTask10.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.add(employeeDto);
        return new ResponseEntity<>("Employee added",HttpStatus.CREATED);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        EmployeeDto employeeDto = employeeService.get(id);
        return new ResponseEntity<>(employeeDto,HttpStatus.FOUND);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<>("Employee deleted",HttpStatus.OK);
    }
}
