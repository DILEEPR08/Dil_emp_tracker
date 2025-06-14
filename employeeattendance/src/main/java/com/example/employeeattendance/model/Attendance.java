package com.example.employeeattendance.model;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "attendances")
public class Attendance {

    @Id
    private String id;

    private String employeeId;
    private String date; // or use LocalDate
    private String status; // e.g., Present, Absent

    // Constructors
    public Attendance() {}

    public Attendance(String employeeId, String date, String status) {
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    // Getters & Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDate(LocalDate date) {
    this.date = date.toString(); // converts LocalDate to ISO string "yyyy-MM-dd"
}

}
