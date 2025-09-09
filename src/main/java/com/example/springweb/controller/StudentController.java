package com.example.springweb.controller;

import com.example.springweb.dto.StudentCreateDto;
import com.example.springweb.model.Student;
import com.example.springweb.model.User;
import com.example.springweb.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        if(studentService.getStudentById(id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(studentService.getStudentById(id));
    }

    @PostMapping()
    public Student createStudent(@RequestBody StudentCreateDto student){
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id){
        return studentService.deleteStudent(id);
    }
}
