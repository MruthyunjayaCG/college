package com.happiest.minds.gradeservice.Service;

import com.happiest.minds.gradeservice.Entity.GradeEntity;
import com.happiest.minds.gradeservice.Repository.Graderepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class GradeService {

    @Autowired
    Graderepository gradeRepository;

    @Autowired
    RestTemplate restTemplate;

    public GradeEntity create(@RequestBody GradeEntity gradeEntity) {
        return gradeRepository.save(gradeEntity);
    }

    public Optional<GradeEntity> getGrade(Integer id) {
        return gradeRepository.findById(id);
    }

    public GradeEntity update(GradeEntity gradeEntity) {
        return gradeRepository.save(gradeEntity);
    }

    public void delete(Integer id) {
        gradeRepository.deleteById(id);
    }

    public List<GradeEntity> getAllGrade() {
        return gradeRepository.findAll();
    }
}
