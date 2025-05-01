package com.example.employeedetails.service;

import com.example.employeedetails.dao.EmployeeRepository;
import com.example.employeedetails.dto.Response;
import com.example.employeedetails.entity.Employee;
import com.example.employeedetails.exception.DataAlreadyExistException;
import com.example.employeedetails.exception.DataNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeesRepository;

    @Override
    public List<Response> getEmployeeList(){
        log.info("Getting Employee List");
        List<Employee> employeeList = employeesRepository.findAll();
        if(employeeList.isEmpty()){
            throw new NullPointerException("No Data available");
        }
        return employeeList.stream().map(this :: mapToResponse).toList();
    }

    private Response mapToResponse(Employee employee) {
        return Response.builder()
                .id(employee.getId())
                .name(employee.getName())
                .address(employee.getAddress())
                .contact(employee.getContact())
                .build();
    }

    @Override
    public Employee getEmployeeById(long id){
        Optional<Employee> employeeOptional = employeesRepository.findById(id);
        return employeeOptional.orElseThrow(() -> new NullPointerException("Employee not found with ID: " + id));
    }

    @Override
    public Employee addEmployee(Employee employee) {
        log.info("Adding Employee data");
        Optional<Employee> employees = employeesRepository.findById(employee.getId());
        if (employees.isPresent()) throw new DataAlreadyExistException();
            log.info("Employee data added");
            employeesRepository.save(employee);
            return employee;
    }

    @Override
    public Employee updateEmployee(long id, Employee updatedEmployee) {
        Optional<Employee> employee = employeesRepository.findById(id);
        if (!employee.isPresent()) {
            throw new DataNotFoundException("Employee data not found for the given ID: "+id);
        }
        log.info("Employee Data updated");
        employeesRepository.delete(employee.get());
        employeesRepository.save(updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public Employee deleteEmployee(long id) {
        log.info("Deleting Employee data by ID: "+id);
        Optional<Employee> employee = employeesRepository.findById(id);
        if(!employee.isPresent()){
            throw new DataNotFoundException("Employee Data not found");
        }
        employeesRepository.deleteById(id);
        return employee.get();
    }
}
