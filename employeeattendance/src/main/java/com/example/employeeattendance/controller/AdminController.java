package com.example.employeeattendance.controller;

import com.example.employeeattendance.scheduler.AttendanceScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AttendanceScheduler attendanceScheduler;    

    @GetMapping("/trigger-absent")
    public ResponseEntity<String> triggerAbsentMarking() {
        attendanceScheduler.markAbsentEmployees();
        return ResponseEntity.ok("Absent employees marked.");
    }
}
