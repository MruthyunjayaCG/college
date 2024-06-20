package com.happiest.minds.courseservice.Repository;

import com.happiest.minds.courseservice.Entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<StudentCourse,Integer> {
    List<StudentCourse> findAllByStudentId(Integer studentId);

    List<StudentCourse> findAllByCourseId(String courseId);
}

