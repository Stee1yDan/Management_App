package com.management.employemanager.service;

import com.management.employemanager.model.Employee;
import com.management.employemanager.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeService
{
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository)
    {
        this.employeeRepository = employeeRepository;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepository.findById(id).orElse(null);
    }

    public void deleteEmployee(Long id)
    {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepository.findAll();
    }
}
