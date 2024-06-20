package com.happiest.minds.courseservice.Service;

import com.happiest.minds.courseservice.Entity.CourseEntity;
import com.happiest.minds.courseservice.Entity.StudentCourse;
import com.happiest.minds.courseservice.Repository.CourseRepository;
import com.happiest.minds.courseservice.Repository.StudentCourseRepository;
//import com.happiest.minds.courseservice.response.Student;
import com.happiest.minds.courseservice.Response.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentCourseService
{
    @Autowired
    StudentCourseRepository studentCourseRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RestTemplate restTemplate;

    public StudentCourse create(StudentCourse studentCourse)    {
        return studentCourseRepository.save(studentCourse);
    }

    public Map<String,List<String>> getCoursesForStudent(Integer studentId) {
        List<StudentCourse> studentCourses = studentCourseRepository.findAllByStudentId(studentId);
        List<String> courseList = new ArrayList<>();
        for (StudentCourse studentCourse : studentCourses) {
            CourseEntity courseEntity = courseRepository.getCourseNameByCourseId(studentCourse.getCourseId());
            courseList.add(courseEntity.getCourseName());
        }
        String fullName = getStudentName(studentId);
        Map<String,List<String>> studentCourseMap = new HashMap<>();
        studentCourseMap.put(fullName, courseList);
        return studentCourseMap;
    }

    public String getStudentName(Integer studentId) {
        Student student = restTemplate.getForObject("http://localhost:8082/student/" + studentId, Student.class);
        return student.getFirstName().concat(" ").concat(student.getLastName());
    }

    public Map<String, List<String>> getStudentsForCourse(String courseId) {
        Map<String, List<String>> courseStudentMap = new HashMap<>();
        List<StudentCourse> studentCourses = studentCourseRepository.findAllByCourseId(courseId);
        List<String> studentList = new ArrayList<>();
        String courseName = courseRepository.getCourseNameByCourseId(courseId).getCourseName();
        for(StudentCourse studentCourse : studentCourses) {
            String fullName = getStudentName(studentCourse.getStudentId());
            studentList.add(fullName);
        }
        courseStudentMap.put(courseName, studentList);
        return courseStudentMap;
    }

}