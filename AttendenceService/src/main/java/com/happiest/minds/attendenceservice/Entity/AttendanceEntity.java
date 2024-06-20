package com.happiest.minds.attendenceservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name = "Attendance")
public class AttendanceEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userId;

    private String courseId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PresentDate")
    private Date Date;

    @PrePersist
    private void onCreate()
    {
        Date = new Date();
    }
}