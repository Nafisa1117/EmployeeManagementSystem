package com.masai.service;

import com.masai.exception.LogInException;
import com.masai.model.Login;

public interface LogInService {
	
	public String logInAccount(Login login) throws LogInException;
	
	public String logOutAccount(String key)throws LogInException;

}
