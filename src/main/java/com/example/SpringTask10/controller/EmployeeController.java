package com.example.SpringTask10.controller;


import com.example.SpringTask10.DTO.EmployeeDto;
import com.example.SpringTask10.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("employee")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody @Valid EmployeeDto employeeDto) {
        employeeService.add(employeeDto);
        log.info("Employee added successfully");
        return new ResponseEntity<>("Employee added",HttpStatus.CREATED);
    }

    @GetMapping("/getById")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        EmployeeDto employeeDto = employeeService.get(id);
        log.info("Employee found successfully");
        return new ResponseEntity<>(employeeDto,HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody @Valid EmployeeDto employeeDto, @RequestParam Integer id) {
        employeeService.update(employeeDto,id);
        log.info("Employee updated successfully");
        return new ResponseEntity<>("Employee updated",HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam Integer id) {
        employeeService.delete(id);
        log.info("Employee deleted successfully");
        return new ResponseEntity<>("Employee deleted",HttpStatus.OK);
    }
}
