package com.example.employeeattendance.controller;

import com.example.employeeattendance.model.Attendance;
import com.example.employeeattendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendances")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // POST /api/attendances
    @PostMapping
    public Attendance markAttendance(@RequestBody Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // GET /api/attendances
    @GetMapping
    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }
}
