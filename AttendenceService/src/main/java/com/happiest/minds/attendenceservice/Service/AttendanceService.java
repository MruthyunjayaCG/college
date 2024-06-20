package com.happiest.minds.attendenceservice.Service;

import com.happiest.minds.attendenceservice.Entity.AttendanceEntity;
import com.happiest.minds.attendenceservice.Repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService
{
    @Autowired
    AttendanceRepository attendanceRepository;

    @Autowired
    RestTemplate restTemplate;

    public AttendanceEntity create(@RequestBody AttendanceEntity attendanceEntity) {
        return attendanceRepository.save(attendanceEntity);
    }

    public Optional<AttendanceEntity> getAttendance(Integer id) {
        return attendanceRepository.findById(id);
    }

    public AttendanceEntity update(AttendanceEntity attendanceEntity) {
        return attendanceRepository.save(attendanceEntity);
    }



    public void delete(Integer id) {
        attendanceRepository.deleteById(id);
    }

    public List<AttendanceEntity> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public List<AttendanceEntity> getDate() {
        return attendanceRepository.findAll();
    }


}