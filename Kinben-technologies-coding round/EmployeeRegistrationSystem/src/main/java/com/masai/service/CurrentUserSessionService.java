package com.masai.service;

import com.masai.exception.LogInException;
import com.masai.model.CurrentUserSession;
import com.masai.model.SignUp;

public interface CurrentUserSessionService {
	
	public CurrentUserSession getCurrentUserSession(String key)throws LogInException;
	
	public Integer getCurrentUserSessionId(String key) throws LogInException;
	
	public SignUp getSignUpDetails(String key)throws LogInException;

}
