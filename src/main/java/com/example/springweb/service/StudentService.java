package com.example.springweb.service;

import com.example.springweb.model.Student;
import com.example.springweb.model.User;
import com.example.springweb.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id).orElse(null);
    }

    public Student createStudent(Student student){
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
