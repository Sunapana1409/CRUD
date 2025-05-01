package com.example.employeedetails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "EMPLOYEE_DETAILS")
public class Employee {


    @Id
    @Column(name = "EMPLOYEE_ID", nullable = false)
    private long id;

    @Column(name = "EMPLOYEE_NAME")
    private String name;

    @Column(name = "EMPLOYEE_ADDRESS")
    private String address;

    @Column(name = "EMPLOYEE_CONTACT")
    private long contact;

}
