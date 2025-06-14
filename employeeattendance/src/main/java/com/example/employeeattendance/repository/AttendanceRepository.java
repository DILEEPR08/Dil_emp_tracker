package com.example.employeeattendance.repository;

import com.example.employeeattendance.model.Attendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceRepository extends MongoRepository<Attendance, String> {
    List<Attendance> findByDate(LocalDate date);

    @Query("{ 'employeeId': ?0, 'date': { $gte: ?1, $lte: ?2 } }")
    List<Attendance> findByEmployeeIdAndDateRange(String employeeId, LocalDate start, LocalDate end);
}
