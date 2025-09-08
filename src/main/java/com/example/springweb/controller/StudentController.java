package com.example.springweb.controller;

/*
4. REST-контроллер

Создать StudentController.
Настроить базовый путь /api/students.

Реализовать эндпоинты:
GET /api/students — вернуть список всех студентов.
GET /api/students/{id} — вернуть одного студента по ID.
POST /api/students — создать нового студента (из JSON).
PUT /api/students/{id} — обновить студента по ID.
DELETE /api/students/{id} — удалить студента по ID.
 */

import com.example.springweb.model.Student;
import com.example.springweb.model.User;
import com.example.springweb.service.StudentService;
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
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping()
    public Student createStudent(@RequestBody Student student){
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
