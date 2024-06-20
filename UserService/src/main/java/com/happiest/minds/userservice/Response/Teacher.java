package com.happiest.minds.userservice.Response;

import lombok.Data;

@Data
public class Teacher
{
    private Integer Id;
    private String firstName;
    private String lastName;
    private Integer UserId;
    private String courseId;
}
