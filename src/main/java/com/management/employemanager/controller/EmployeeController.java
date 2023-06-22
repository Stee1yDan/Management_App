package com.management.employemanager.controller;

import com.management.employemanager.model.Employee;
import com.management.employemanager.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService)
    {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees()
    {
        return new ResponseEntity<>(employeeService.findAllEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id)
    {
        return new ResponseEntity<>(employeeService.findEmployeeById(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee)
    {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployeeById(@PathVariable Long id)
    {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/add/dummy")
    public ResponseEntity<Employee> addTestEmployee()
    {
        return new ResponseEntity<>(employeeService.addEmployee(
                new Employee
                        (
                                "Bobson Dugnut",
                                "bobson11@dugnut.com",
                                "Baseball Player",
                                "1-234-56-78",
                                "dugnut.jpg"
                        )
        ), HttpStatus.OK);
    }

}
