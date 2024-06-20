package com.happiest.minds.teacherservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Teacher")
@Data
public class TeacherEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String firstName;

    private String lastName;

    private Integer UserId;

    public String getCourseName() {
        return null;
    }

    public String getTeacherName() {
        return null;
    }

//    private String courseId;

}
