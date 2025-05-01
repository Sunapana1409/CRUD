package com.example.employeedetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class EmployeeDetails extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(EmployeeDetails.class, args);
	}
//
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(EmployeeDetails.class);
//	}

}
