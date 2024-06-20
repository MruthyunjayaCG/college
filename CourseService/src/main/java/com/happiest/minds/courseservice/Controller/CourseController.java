package com.happiest.minds.courseservice.Controller;

import com.happiest.minds.courseservice.Entity.CourseEntity;
import com.happiest.minds.courseservice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/course")
    public class CourseController {

        @Autowired
        CourseService courseService;
        @Autowired
        RestTemplate restTemplate;

        @PostMapping
        public CourseEntity create(@RequestBody CourseEntity courseEntity) {
            return courseService.create(courseEntity);
        }

        @GetMapping("/{id}")

        public Optional<CourseEntity> getCourse(@PathVariable(name = "id") Integer id) {
            return courseService.getCourse(id);
        }

        @PutMapping
        public CourseEntity update(@RequestBody CourseEntity courseEntity) {
            return courseService.update(courseEntity);
        }

        @GetMapping
        public List<CourseEntity> getAllCourse() {
            return courseService.getAllCourse();
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Integer id) {
            courseService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
