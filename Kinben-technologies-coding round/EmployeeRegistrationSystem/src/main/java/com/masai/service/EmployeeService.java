package com.masai.service;

import java.util.List;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;

public interface EmployeeService {
	
	public Employee registerEmployee(Employee emp);
	
	public List<Employee> getAllEmployee() throws EmployeeException;
	
	public Employee findByEmployeeId(Integer id)throws EmployeeException;
	
	public Employee updateEmployeeDetails(Employee emp) throws EmployeeException;
	

}
