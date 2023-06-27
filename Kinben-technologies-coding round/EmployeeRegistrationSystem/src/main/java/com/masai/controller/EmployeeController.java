package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService empService;
	
	@PostMapping("/Employee")
	public ResponseEntity<Employee> registerEmployee(@RequestBody Employee empl) {
		Employee emp = empService.registerEmployee(empl);
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	@GetMapping("/Employee")
	public ResponseEntity<List<Employee>> getAllEmployee() throws EmployeeException{
	   List<Employee> getEmp = empService.getAllEmployee();
	 return new ResponseEntity<List<Employee>>(getEmp, HttpStatus.OK);
}
	
	@GetMapping("/Employee/{id}")
	public ResponseEntity<Employee> findByEmployeeId(@PathVariable("id") Integer id)throws EmployeeException{
		Employee emp = empService.findByEmployeeId(id);
		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}
	
	@PutMapping("/Employee")
	public ResponseEntity<Employee> updateEmployeeDetails(Employee emp) throws EmployeeException{
		Employee empl = empService.updateEmployeeDetails(emp);
		return new ResponseEntity<Employee>(empl, HttpStatus.OK);
	}
}
