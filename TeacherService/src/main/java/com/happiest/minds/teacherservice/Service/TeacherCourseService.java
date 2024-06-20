package com.happiest.minds.teacherservice.Service;

import com.happiest.minds.teacherservice.Entity.TeacherCourseEntity;
import com.happiest.minds.teacherservice.Entity.TeacherEntity;
import com.happiest.minds.teacherservice.Repository.TeacherCourseRepo;
import com.happiest.minds.teacherservice.Repository.TeacherRepo;
import com.happiest.minds.teacherservice.Response.CourseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherCourseService
{
    @Autowired
    TeacherCourseRepo teacherCourseRepo;

    @Autowired
    TeacherRepo teacherRepo;

    @Autowired
    RestTemplate restTemplate;

    public TeacherCourseEntity create (TeacherCourseEntity teacherCourseEntity)
    {
        return teacherCourseRepo.save(teacherCourseEntity);
    }

    public Map<String,List<String>> getTeachersForCourse(Integer courseId) {
        List<TeacherCourseEntity> teacherCourses = teacherCourseRepo.findAllByCourseId(courseId);
        List<String> teacherList = new ArrayList<>();
        for (TeacherCourseEntity teacherCourseEntity : teacherCourses) {
            TeacherEntity teacherEntity = teacherRepo.getTeacherNameByTeacherId(teacherCourseEntity.getTeacherId());
            teacherList.add(teacherEntity.getTeacherName());
        }
        String fullName = getCourseName(courseId);
        Map<String,List<String>> teacherCourseMap = new HashMap<>();
        teacherCourseMap.put(fullName, teacherList);
        return teacherCourseMap;
    }

    public String getCourseName(Integer courseId) {
        CourseEntity courseEntity = restTemplate.getForObject("http://localhost:8082/student/" + courseId, CourseEntity.class);
        return courseEntity.getFirstName().concat(" ").concat(courseEntity.getLastName());
    }


}
