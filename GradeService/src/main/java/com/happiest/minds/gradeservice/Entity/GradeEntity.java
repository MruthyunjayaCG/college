package com.happiest.minds.gradeservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Grade")
@Data
public class GradeEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;
    private String Grade;
    private String userId;
    private String courseId;
}
