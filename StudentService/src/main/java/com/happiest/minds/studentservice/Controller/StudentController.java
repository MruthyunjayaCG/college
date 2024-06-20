package com.happiest.minds.studentservice.Controller;

import com.happiest.minds.studentservice.Entity.Student;
import com.happiest.minds.studentservice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping
    public Student create(@RequestBody Student student)  {
        return studentService.create(student);
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable(name = "id") Long id) {
        return studentService.getStudent(id).get();
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Long id) {
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
