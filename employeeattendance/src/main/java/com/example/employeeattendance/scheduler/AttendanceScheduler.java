package com.example.employeeattendance.scheduler;

import com.example.employeeattendance.model.Attendance;
import com.example.employeeattendance.model.Employee;
import com.example.employeeattendance.repository.AttendanceRepository;
import com.example.employeeattendance.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class AttendanceScheduler {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Scheduled(cron = "0 0 6 * * ?") // 6 AM daily
    public void markAbsentEmployees() {
        LocalDate today = LocalDate.now();

        List<Employee> allEmployees = employeeRepository.findAll();
        List<Attendance> presentToday = attendanceRepository.findByDate(today);

        List<String> presentIds = presentToday.stream()
                .map(Attendance::getEmployeeId)
                .collect(Collectors.toList());

        List<Employee> absentEmployees = allEmployees.stream()
                .filter(emp -> !presentIds.contains(emp.getId()))
                .collect(Collectors.toList());

        for (Employee emp : absentEmployees) {
            Attendance att = new Attendance();
            att.setEmployeeId(emp.getId());
            att.setDate(today);
            att.setStatus("Absent");
            attendanceRepository.save(att);
        }
    }
}
