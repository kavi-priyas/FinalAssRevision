package com.example.demo;

import java.util.HashMap;
import java.util.*;

public class Employeerepo {
    private Map<Integer,Employee> empmap=new HashMap<>();
    //save
    public Employee save(Employee emp){
        empmap.put(emp.getId(), emp);
        return emp;
    }
    //read all
    public List<Employee> findAll(){
        return new ArrayList<>(empmap.values());
    }
    //read by id
    public Optional<Employee> findById(int id){
        return Optional.ofNullable(empmap.get(id));

    }
    //update
    public Employee update (Employee emp){
        empmap.put(emp.getId(),emp);
        return emp;
    }
    //delete
    public void deleteById(int id){
        empmap.remove(id);
    }
}
