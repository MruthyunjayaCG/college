package com.happiest.minds.courseservice.Service;

//import com.happiest.minds.courseservice.Controller.CourseController;
import com.happiest.minds.courseservice.Entity.CourseEntity;
import com.happiest.minds.courseservice.Repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;


import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    @Autowired
    CourseRepository courseRepository;

    @Autowired
    RestTemplate restTemplate;
    public CourseEntity create(@RequestBody CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
    public Optional<CourseEntity> getCourse(Integer id) {
        return courseRepository.findById(id);
    }
    public CourseEntity update(CourseEntity courseEntity) {
        return courseRepository.save(courseEntity);
    }
    public void delete(Integer id) {
        courseRepository.deleteById(id);
    }
    public List<CourseEntity> getAllCourse() {
        return courseRepository.findAll();
    }
}
