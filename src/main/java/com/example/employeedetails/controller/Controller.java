package com.example.employeedetails.controller;


import com.example.employeedetails.dto.Response;
import com.example.employeedetails.entity.Employee;
import com.example.employeedetails.exception.DataAlreadyExistException;
import com.example.employeedetails.exception.DataNotFoundException;
import com.example.employeedetails.service.EmployeeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@Slf4j
@RestController
@RequestMapping("/employee")
public class Controller {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @GetMapping("/getEmployeeList")
    public ResponseEntity<Response> getEmployeeList() {
        log.info("Getting Employee List");

        try{
            return new ResponseEntity(employeeService.getEmployeeList(), HttpStatus.OK );
        }catch (NullPointerException nullPointerException){
            log.error("No Employee data available");
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No Employee content");
        }
    }
    @GetMapping("/getEmployeeList/{id}")
    public ResponseEntity getEmployeeListById(@PathVariable("id") long id) {
        log.info("Getting Employee list by ID: " +id);
        try {
            return new ResponseEntity(employeeService.getEmployeeById(id), HttpStatus.OK );
        } catch (NullPointerException nullPointerException) {
            log.error("Employee data not found for the ID: "+id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Employee Data not found for the ID: " + id);
        }
    }

    @PostMapping("/addEmployee")
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        log.info("Entering POST mapping to add employee data");
        try {
            return new ResponseEntity(employeeService.addEmployee(employee), HttpStatus.CREATED);
        } catch (DataAlreadyExistException dataAlreadyExistException) {
            log.error("Employee details already available for the given ID: "+ employee.getId());
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "Data already Exist for the ID: " + employee.getId());
        }
    }
    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity updateEmployee(@RequestBody Employee employee, @PathVariable("id") long id) {
        log.info("Updating employee Data");
        try {
            return new ResponseEntity(employeeService.updateEmployee(id, employee),HttpStatus.OK);
        } catch (DataNotFoundException dataNotFoundException) {
            log.error("Data not found for the given ID: " + id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Data not found for the given ID: " + id);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deteleEmployee(@PathVariable long id) {
        log.info("Employee data deleted successfully");
        try {
            return new ResponseEntity(employeeService.deleteEmployee(id), HttpStatus.OK);
        } catch (DataNotFoundException dataNotFoundException) {
            log.error("Employee data not found to delete");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee data not found to delete");
        }
    }
}
