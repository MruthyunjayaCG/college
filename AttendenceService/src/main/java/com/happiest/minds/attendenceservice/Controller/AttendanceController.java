package com.happiest.minds.attendenceservice.Controller;

import com.happiest.minds.attendenceservice.Entity.AttendanceEntity;
import com.happiest.minds.attendenceservice.Service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Attendance")
public class AttendanceController
{
    @Autowired
    AttendanceService attendanceService;

    @Autowired
    RestTemplate restTemplate;

    @PostMapping
    public AttendanceEntity create(@RequestBody AttendanceEntity attendanceEntity)
    {
        return attendanceService.create(attendanceEntity);
    }

    @GetMapping("/{id}")
    public Optional<AttendanceEntity> getAttendance(@PathVariable(name = "id") Integer id)
    {
        return attendanceService.getAttendance(id);
    }

    @PutMapping
    public AttendanceEntity update(@RequestBody AttendanceEntity student)
    {
        return attendanceService.update(student);
    }

    @GetMapping
    public List<AttendanceEntity> getAllAttendance()
    {
        return attendanceService.getAllAttendance();
    }

    @RequestMapping(value = "/location",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    public List<AttendanceEntity> getDate(@RequestBody AttendanceEntity attendanceEntity)
        throws Exception
    {
        return attendanceService.getDate();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatusCode> delete(@PathVariable(name = "id") Integer id)
    {
        attendanceService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}