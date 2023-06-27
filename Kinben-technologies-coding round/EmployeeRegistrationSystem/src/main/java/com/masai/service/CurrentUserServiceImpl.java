package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LogInException;
import com.masai.model.CurrentUserSession;
import com.masai.model.SignUp;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.SignUpDao;

@Service
public class CurrentUserServiceImpl implements CurrentUserSessionService{

	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private SignUpDao signUpDao;
	
	@Override
	public CurrentUserSession getCurrentUserSession(String key) throws LogInException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> currentUser = currentUserSessionDao.findByUserUniqueId(key);
		if(!currentUser.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentUser.get();
	}

	@Override
	public Integer getCurrentUserSessionId(String key) throws LogInException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> currentUser = currentUserSessionDao.findByUserUniqueId(key);
		if(!currentUser.isPresent())
		{
			throw new LogInException("UnAuthorized!!!");
		}
		return currentUser.get().getId();
	}

	@Override
	public SignUp getSignUpDetails(String key) throws LogInException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> currentUser = currentUserSessionDao.findByUserUniqueId(key);
		if(!currentUser.isPresent())
		{
			return null;
		}
		Integer SignUpUserId = currentUser.get().getUserId();
		System.out.println(SignUpUserId );
		
		return (signUpDao.findById(SignUpUserId)).get();
	}

}
