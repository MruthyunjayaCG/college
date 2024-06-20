package com.happiest.minds.gradeservice.Repository;

import com.happiest.minds.gradeservice.Entity.GradeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Graderepository extends JpaRepository<GradeEntity,Integer> {
}
