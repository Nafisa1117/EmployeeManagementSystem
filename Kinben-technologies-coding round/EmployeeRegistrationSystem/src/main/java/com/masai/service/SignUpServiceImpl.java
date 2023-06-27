package com.masai.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.EmployeeException;
import com.masai.exception.LogInException;
import com.masai.model.SignUp;
import com.masai.repository.SignUpDao;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private SignUpDao signUpDao;
	
	@Autowired
	private CurrentUserSessionService getCurrentLoginUserSession;

	@Override
	public SignUp createNewSignUp(SignUp signUp) throws LogInException {
		// TODO Auto-generated method stub
		System.out.println(signUp);
		
		Optional<SignUp> opt = signUpDao.findByUserName(signUp.getUserName());
		if(opt.isPresent())
		{
			throw new LogInException("User Already Exist!");
		}
		
		return signUpDao.save(signUp);
	}

	@Override
	public SignUp updateSignUpDetails(SignUp signUp, String key) throws LogInException {
		// TODO Auto-generated method stub
			SignUp signUpDetails = getCurrentLoginUserSession.getSignUpDetails(key);
		
		if(signUpDetails == null)
		{
			throw new LogInException("UnAuthorized!!! No User Found....Try To login first!");
		}
		
		if(signUpDetails.getUserId() == signUp.getUserId())
			{
			signUpDao.save(signUp);
			return signUp;
			}
		else
			throw new LogInException("Can't change UserId!!");
	}

	@Override
	public List<SignUp> showAllEmployees() throws EmployeeException {
		// TODO Auto-generated method stub
		List<SignUp> customers=signUpDao.findAll();
		if(customers.size()==0) {
			throw new EmployeeException("no customer available");
		}
		return customers; 
	}

	@Override
	public SignUp deleteEmployees(Integer userId) throws EmployeeException {
		// TODO Auto-generated method stub
		Optional<SignUp> opt= signUpDao.findById(userId);
		
		if(opt.isPresent()) {
			SignUp existcustomer = opt.get();
			signUpDao.delete(existcustomer);
			return existcustomer;
		}
		else
			throw new EmployeeException("no customer found");
		
		
	}


}
