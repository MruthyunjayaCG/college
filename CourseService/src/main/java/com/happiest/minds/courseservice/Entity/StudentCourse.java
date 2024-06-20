package com.happiest.minds.courseservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "student_course")
public class StudentCourse
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String  courseId;
    private Integer studentId;

    public Integer getStudentId() {
        return null;
    }

    public String getCourseId() {
        return null;
    }
}
