package com.example.employeeattendance.controller;

import com.example.employeeattendance.model.Department;
import com.example.employeeattendance.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;

    // POST /api/departments
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // GET /api/departments
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
}
