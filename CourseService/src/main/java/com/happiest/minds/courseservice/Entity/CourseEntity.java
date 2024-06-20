package com.happiest.minds.courseservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Course")
@Data
public class CourseEntity
{
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Integer Id;
        private String courseId;
        private String courseName;
        private String duration;
        private Integer teacherId;

}
