package com.example.employeeattendance.service;

import com.example.employeeattendance.model.Attendance;
import com.example.employeeattendance.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Daily summary task at 6 AM
    @Scheduled(cron = "0 0 6 * * *")
    public void generateDailyReport() {
        LocalDate today = LocalDate.now();
        List<Attendance> todaysRecords = attendanceRepository.findByDate(today);
        System.out.println("Daily Report for " + today + ": " + todaysRecords.size() + " records.");
    }
}

