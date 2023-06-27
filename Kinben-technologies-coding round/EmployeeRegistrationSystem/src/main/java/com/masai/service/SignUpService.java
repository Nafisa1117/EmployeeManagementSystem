package com.masai.service;

import java.util.List;

import javax.security.auth.login.LoginException;

import com.masai.exception.EmployeeException;
import com.masai.exception.LogInException;
import com.masai.model.SignUp;



public interface SignUpService {
	
	public SignUp createNewSignUp(SignUp signUp)throws LogInException;
	
	public SignUp updateSignUpDetails(SignUp signUp, String key) throws LogInException;
	
	public List<SignUp> showAllEmployees()throws EmployeeException;

	public SignUp deleteEmployees(Integer userId)throws EmployeeException;
}
