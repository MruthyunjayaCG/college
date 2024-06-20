package com.happiest.minds.teacherservice.Response;

import lombok.Data;

@Data
public class CourseEntity
{
    private Integer Id;
    private String courseName;
    private Integer courseId;
    private String duration;

    public String getFirstName() {
        return null;
    }

    public String getLastName() {
        return null;
    }
}
