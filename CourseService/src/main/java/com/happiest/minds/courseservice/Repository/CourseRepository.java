package com.happiest.minds.courseservice.Repository;

import com.happiest.minds.courseservice.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<CourseEntity,Integer> {
    CourseEntity getCourseNameByCourseId(String courseId);

}
