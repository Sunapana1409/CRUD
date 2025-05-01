package com.example.employeedetails.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.employeedetails.dao.EmployeeRepository;
import com.example.employeedetails.entity.Employee;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    private EmployeeRepository employeeRepository;

    public Query(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Iterable<Employee> getEmployeeData(){
        return employeeRepository.findAll();
    }
}
