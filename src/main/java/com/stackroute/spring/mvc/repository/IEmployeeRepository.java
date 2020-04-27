package com.stackroute.spring.mvc.repository;

import java.util.List;

import com.stackroute.spring.mvc.entity.Employee;

public interface IEmployeeRepository {

	
	public Employee saveEmployee(Employee employee);
	public Employee getEmployeeById(int id);
	public Employee updateEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean deleteEmployee(int id);
}
