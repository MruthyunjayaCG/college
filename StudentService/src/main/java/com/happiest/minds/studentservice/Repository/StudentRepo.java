package com.happiest.minds.studentservice.Repository;

import com.happiest.minds.studentservice.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Long> {
}