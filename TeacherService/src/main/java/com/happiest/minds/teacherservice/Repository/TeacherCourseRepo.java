package com.happiest.minds.teacherservice.Repository;

import com.happiest.minds.teacherservice.Entity.TeacherCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeacherCourseRepo extends JpaRepository<TeacherCourseEntity, Integer> {
    List<TeacherCourseEntity> findAllByStudentId(Integer teacherId);

    List<TeacherCourseEntity> findAllByCourseId(Integer courseId);
}
