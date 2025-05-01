package com.example.employeedetails.service;


import com.example.employeedetails.dto.Response;
import com.example.employeedetails.entity.Employee;
import jakarta.validation.Valid;

import java.util.List;

public interface EmployeeService {
    List<Response> getEmployeeList();

    Employee getEmployeeById(long id);

    Employee addEmployee(@Valid Employee employee);

    Employee updateEmployee(long id, @Valid Employee updatedEmployee);

    Employee deleteEmployee(long id);
}
