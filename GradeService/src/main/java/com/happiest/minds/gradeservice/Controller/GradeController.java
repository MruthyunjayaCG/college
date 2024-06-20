package com.happiest.minds.gradeservice.Controller;

import com.happiest.minds.gradeservice.Entity.GradeEntity;
import com.happiest.minds.gradeservice.Service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Grade")
public class GradeController {
    @Autowired
    GradeService gradeService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public GradeEntity create(@RequestBody GradeEntity gradeEntity) {
        return gradeService.create(gradeEntity);
    }

    @GetMapping("/{id}")
    public Optional<GradeEntity> getGrade(@PathVariable(name = "id") Integer id) {
        return gradeService.getGrade(id);
    }

    @GetMapping
    public List<GradeEntity> getAllGrade() {
        return gradeService.getAllGrade();
    }

    @PutMapping
    public GradeEntity upadte(@RequestBody GradeEntity gradeEntity) {
        return gradeService.update(gradeEntity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Integer id) {
        gradeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
