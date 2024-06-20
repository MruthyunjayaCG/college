package com.happiest.minds.teacherservice.Service;

import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Repository.TeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
@Service
public class TeacherService
{
    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    RestTemplate restTemplate;

    public TeacherEntity create(@RequestBody TeacherEntity teacherEntity) {
        return teacherRepo.save(teacherEntity);
    }

    public Optional<TeacherEntity> getteacher(Integer id) {
        return teacherRepo.findById(id);
    }

    public TeacherEntity update(TeacherEntity teacherEntity) {
        return teacherRepo.save(teacherEntity);
    }

    public void delete(Integer id) {
        teacherRepo.deleteById(id);
    }

    public List<TeacherEntity> getAllTeacher() {
        return teacherRepo.findAll();
    }
}
