package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/api/emp")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @PostMapping
    public Employee createEmployee(@RequestBody Employee emp){
        return employeeService.createEmployee(emp);
    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeService.ReadallEmployess();
    }
    @GetMapping("/{id}")
    public Employee findbyId(@PathVariable Long id){
        return employeeService.findByid(id);
    }
    @PutMapping()
        public Employee updateEmployee(@RequestBody Employee uEmployee,@PathVariable Long id){
            return employeeService.updatEmployee(id,uEmployee);
    }
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.findByid(id);
    }
}

