package com.example.springweb.controller;

import com.example.springweb.model.Course;
import com.example.springweb.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.Optional.empty;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public ResponseEntity<List<Course>> getCourses(){
      return ResponseEntity.ok().body(courseService.getCourses());
    };

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id){
        if(courseService.getCourseById(id) == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(courseService.getCourseById(id));
    }
// TODO::
//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Course> createCourse(@RequestBody Course course){
//        if(courseService.createCourse(course) == null){
//            return ResponseEntity.badRequest().build();
//        }
//        return ResponseEntity.ok().body(courseService.createCourse(course));
//    }

}
