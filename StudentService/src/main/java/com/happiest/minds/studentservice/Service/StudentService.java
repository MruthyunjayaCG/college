package com.happiest.minds.studentservice.Service;

import com.happiest.minds.studentservice.Entity.Student;
import com.happiest.minds.studentservice.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepo studentRepo;


    public Student create(@RequestBody Student student) {
        return studentRepo.save(student);
    }

    public Optional<Student> getStudent(Long id) {
        return studentRepo.findById(id);
    }

    public Student update(Student student) {
        return studentRepo.save(student);
    }

    public void delete(Long id) {
        studentRepo.deleteById(id);
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }
}