package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    private final Employeerepo employeerepo;

    public EmployeeService(Employeerepo employeerepo) {
        this.employeerepo = employeerepo;
    }
    //createemployee
    public Employee creatEmployee(Employee emp){
        return employeerepo.save(emp);
    }
    //readall
    public List<Employee> getalldetails(){
        return employeerepo.findAll();
    }
    //readbyId
    public Employee getById(int id){
        return employeerepo.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
    }
    //update
    public Employee updateEmployee(Employee emp){
        return employeerepo.update(emp);
    }
    //delete
    public void deleteEmployee(int id){
        employeerepo.deleteById(id);
    }
}
