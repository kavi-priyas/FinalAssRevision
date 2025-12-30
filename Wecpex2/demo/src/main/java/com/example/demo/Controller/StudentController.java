package com.example.demo.Controller;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // USER + ADMIN
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
            // USER + ADMIN
    @GetMapping("/{id}")
    
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    // ADMIN only
    @PostMapping
 
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // ADMIN only
    @PutMapping("/{id}")
   
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // ADMIN only
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    }

