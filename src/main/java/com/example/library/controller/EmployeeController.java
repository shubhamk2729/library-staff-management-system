package com.example.library.controller;

import com.example.library.model.Employee;
import com.example.library.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "*")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @PostMapping
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable String id) {
        employeeRepository.deleteById(id);
    }

    @PutMapping("/{id}/clock-in")
    public Employee clockIn(@PathVariable String id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setInTime(LocalDateTime.now().format(formatter));
        emp.setOutTime("Working..."); // Reset out-time when a new shift starts
        return employeeRepository.save(emp);
    }

    @PutMapping("/{id}/clock-out")
    public Employee clockOut(@PathVariable String id) {
        Employee emp = employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
        emp.setOutTime(LocalDateTime.now().format(formatter));
        return employeeRepository.save(emp);
    }
}