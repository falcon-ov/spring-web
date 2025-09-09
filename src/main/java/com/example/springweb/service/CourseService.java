package com.example.springweb.service;

import com.example.springweb.model.Course;
import com.example.springweb.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCourses(){
        return courseRepository.findAll();
    }

    public Course getCourseById(Long id){
        return courseRepository.findById(id).orElse(null);
    }
//TODO::
//    public Course createCourse(Course course){
//        try{
//            return courseRepository.save(course);
//        }catch (Exception e){
//            return null;
//        }
//    }
}
