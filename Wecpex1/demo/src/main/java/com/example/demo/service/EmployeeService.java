package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.repo.EmployeeRepo;

@Service
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public Employee createEmployee(Employee employee){
        return employeeRepo.save(employee);
    }
    public List<Employee> ReadallEmployess(){
        return employeeRepo.findAll();
    }
    public Employee findByid(Long id){
        return employeeRepo.findById(id).orElse(null);
    }
    public Employee updatEmployee(Long id,Employee updatedEmployee){
        return employeeRepo.findById(id).map(e->{
            e.setId(updatedEmployee.getId());
            e.setName(updatedEmployee.getName());
            e.setSalary(updatedEmployee.getSalary());
            e.setDepartment(updatedEmployee.getDepartment());
            return employeeRepo.save(e);
        }).orElse(null);
    }
    public void deleteEmployee(Long id){
         employeeRepo.deleteById(id);
    }
}
