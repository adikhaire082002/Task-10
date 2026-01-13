package com.example.SpringTask10.service;

import com.example.SpringTask10.DTO.EmployeeDto;
import com.example.SpringTask10.entity.Employee;
import com.example.SpringTask10.exception.ResourceNotFound;
import com.example.SpringTask10.mapper.EmployeeMapper;
import com.example.SpringTask10.repositoy.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private EmployeeMapper employeeMapper;

    public void add(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.toEmployee(employeeDto);
        try{
            employeeRepo.save(employee);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public EmployeeDto get(Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found"));
        return employeeMapper.toEmployeeDto(employee);
    }

    public void delete(Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found"));
        employeeRepo.delete(employee);
    }

    public void update(EmployeeDto employeeDto, Integer id) {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new ResourceNotFound("Employee not found"));
        Employee employee1 = employeeMapper.toEmployee(employeeDto, employee);
        try{
            employeeRepo.save(employee1);
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
