package com.happiest.minds.courseservice.Controller;

import com.happiest.minds.courseservice.Entity.StudentCourse;
import com.happiest.minds.courseservice.Service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/enroll")
public class StudentCourseController {
    @Autowired
    StudentCourseService studentCourseService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public StudentCourse create(@RequestBody StudentCourse studentCourse) {
        return studentCourseService.create(studentCourse);
    }

    @GetMapping("/{studentId}")
    public Map<String, List<String>> getCoursesForStudent(@PathVariable Integer studentId) {
        return studentCourseService.getCoursesForStudent(studentId);
    }

    @DeleteMapping("/{courseId}")
    public Map<String,List<String>> getStudentsForcourse(@PathVariable String courseId)
    {
        return studentCourseService.getStudentsForCourse(courseId);
    }
}


