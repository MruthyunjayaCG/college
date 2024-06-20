package com.happiest.minds.teacherservice.Controller;

import com.happiest.minds.teacherservice.Entity.TeacherCourseEntity;
import com.happiest.minds.teacherservice.Service.TeacherCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachercourse")
public class TeacherCourseControl
{
    @Autowired
    TeacherCourseService teacherCourseService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public TeacherCourseEntity create(@RequestBody TeacherCourseEntity teacherCourseEntity){
        return teacherCourseService.create(teacherCourseEntity);
    }

    @GetMapping("/{studentId}")
    public Map<String, List<String>> getTeachersForCourse(@PathVariable Integer courseId) {
        return teacherCourseService.getTeachersForCourse(courseId);
    }
}
