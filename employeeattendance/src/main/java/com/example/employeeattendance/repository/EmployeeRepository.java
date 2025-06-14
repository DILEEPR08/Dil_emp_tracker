package com.example.employeeattendance.repository;

import com.example.employeeattendance.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EmployeeRepository extends MongoRepository<Employee, String> {
}
