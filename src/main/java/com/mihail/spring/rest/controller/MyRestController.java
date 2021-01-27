package com.mihail.spring.rest.controller;

import com.mihail.spring.rest.entity.Employee;
import com.mihail.spring.rest.exception_handling.EmployeeIncorrectData;
import com.mihail.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api")
public class MyRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees() {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee showEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){
            throw new NoSuchElementException("Employee with id = " + id + " not found.");
        }
        return employee;
    }

    @PostMapping ("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping ("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if(employee==null){
            throw new NoSuchElementException("Employee with id = " + id + " not found.");
        }
        employeeService.deleteEmployee(id);
        return "Delete employee with ID = " + id + ";";
    }
}
