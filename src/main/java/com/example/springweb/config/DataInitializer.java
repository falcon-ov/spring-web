package com.example.springweb.config;

import com.example.springweb.model.Course;
import com.example.springweb.model.Student;
import com.example.springweb.repository.CourseRepository;
import com.example.springweb.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
//
//    @Bean
//    CommandLineRunner initData(StudentRepository studentRepository, CourseRepository courseRepository) {
//        return args -> {
//            // создаем курсы
//            Course math = new Course();
//            math.setTitle("Математика");
//
//            Course physics = new Course();
//            physics.setTitle("Физика");
//
//            Course programming = new Course();
//            programming.setTitle("Программирование");
//
//            courseRepository.save(math);
//            courseRepository.save(physics);
//            courseRepository.save(programming);
//
//            // создаем студентов
//            Student dima = new Student();
//            dima.setName("Дима");
//            dima.setAge(20);
//            dima.setEmail("dima@example.com");
//            dima.addCourse(math);
//            dima.addCourse(programming);
//
//            Student masha = new Student();
//            masha.setName("Маша");
//            masha.setAge(21);
//            masha.setEmail("masha@example.com");
//            masha.addCourse(physics);
//            masha.addCourse(programming);
//
//            Student ivan = new Student();
//            ivan.setName("Иван");
//            ivan.setAge(19);
//            ivan.setEmail("ivan@example.com");
//            ivan.addCourse(math);
//
//            studentRepository.save(dima);
//            studentRepository.save(masha);
//            studentRepository.save(ivan);
//        };
//    }
}
