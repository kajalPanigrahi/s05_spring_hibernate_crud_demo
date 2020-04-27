package com.stackroute.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.stackroute.spring.mvc.repository.EmployeeRepository;

@Controller
@RequestMapping("api/v1/employee")
public class EmployeeController {
	
	
	private EmployeeRepository employeeRepository;
	
	
	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		
		this.employeeRepository = employeeRepository;
	}



	@GetMapping("/")
	public String getHomePage() {
		return "index";
	}

}
