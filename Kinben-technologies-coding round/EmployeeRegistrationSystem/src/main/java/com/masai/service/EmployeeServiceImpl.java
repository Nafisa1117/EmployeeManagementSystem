package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.model.Employee;
import com.masai.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDao empDao;
	
	@Override
	public Employee registerEmployee(Employee emp) {
		// TODO Auto-generated method stub
		Employee em = empDao.save(emp);
		return em;
	}

	@Override
	public List<Employee> getAllEmployee() throws EmployeeException {
		// TODO Auto-generated method stub
		List<Employee> em = empDao.findAll();
		if(em.size()==0) {
			throw new EmployeeException();
		}
		return em;
	}

	@Override
	public Employee findByEmployeeId(Integer id) throws EmployeeException {
		// TODO Auto-generated method stub
		return empDao.findById(id).orElseThrow(()-> new EmployeeException());
	}

	@Override
	public Employee updateEmployeeDetails(Employee emp) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<Employee> opt = empDao.findById(emp.getId());
		
		if(opt.isPresent()) {
			Employee updateEmp = empDao.save(emp);
			return updateEmp;
		}
		else 
			throw new EmployeeException();
	}

}
