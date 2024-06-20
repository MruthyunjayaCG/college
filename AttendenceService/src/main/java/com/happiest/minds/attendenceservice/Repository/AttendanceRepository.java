package com.happiest.minds.attendenceservice.Repository;

import com.happiest.minds.attendenceservice.Entity.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Integer> {
}