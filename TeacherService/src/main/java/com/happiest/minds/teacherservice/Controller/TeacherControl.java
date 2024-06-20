package com.happiest.minds.teacherservice.Controller;

import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher")
public class TeacherControl
{
    @Autowired
    TeacherService teacherService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public TeacherEntity create(@RequestBody TeacherEntity teacherEntity) {
        return teacherService.create(teacherEntity);
    }
    @GetMapping("/{id}")
    public Optional<TeacherEntity> getteacher(@PathVariable(name = "id") Integer id) {
        return teacherService.getteacher(id);
    }
    @PutMapping
    public TeacherEntity update(@RequestBody TeacherEntity teacherEntity) {
        return teacherService.update(teacherEntity);
    }
    @GetMapping
    public List<TeacherEntity> getAllTeacher() {
        return teacherService.getAllTeacher();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Integer id) {
        teacherService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}