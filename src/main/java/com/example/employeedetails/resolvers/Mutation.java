package com.example.employeedetails.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.employeedetails.dao.EmployeeRepository;
import com.example.employeedetails.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Mutation implements GraphQLMutationResolver {
    private EmployeeRepository employeeRepository;

    public Employee addData(long id, String name, String address, long contact){

        Employee employee = new Employee(id, name, address, contact);
        employeeRepository.save(employee);
        return employee;
    }

    public Employee deleteEmployee(long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        employeeRepository.deleteById(id);
        return employee.get();
    }
}
