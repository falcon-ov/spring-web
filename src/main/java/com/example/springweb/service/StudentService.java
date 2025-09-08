package com.example.springweb.service;

import com.example.springweb.dto.StudentCreateDto;
import com.example.springweb.model.Course;
import com.example.springweb.model.Student;
import com.example.springweb.model.User;
import com.example.springweb.repository.CourseRepository;
import com.example.springweb.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, CourseRepository courseRepository1) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository1;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(StudentCreateDto dto){
        Student student = new Student();
        student.setName(dto.getName());
        student.setAge(dto.getAge());
        student.setEmail(dto.getEmail());

        student.setCourses(courseRepository.findAllById(dto.getCourseIds()));

        return studentRepository.save(student);
    }

    public Student updateStudent(Long id ,Student studentPatch){
        return studentRepository.findById(id).map(student -> {
                    student.setName(studentPatch.getName());
                    student.setAge(studentPatch.getAge());
                    student.setEmail(studentPatch.getEmail());
                    return studentRepository.save(student);
                }).orElse(null);
    }

    public boolean deleteStudent(Long id){
        if(studentRepository.existsById(id)){
           studentRepository.deleteById(id);
           return true;
        }
        return false;
    }

}
