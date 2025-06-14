package com.example.employeeattendance.repository;

import com.example.employeeattendance.model.Department;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DepartmentRepository extends MongoRepository<Department, String> {
}
