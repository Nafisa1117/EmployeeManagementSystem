package com.masai.service;

import java.time.LocalDateTime;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.LogInException;
import com.masai.model.CurrentUserSession;
import com.masai.model.Login;
import com.masai.model.SignUp;
import com.masai.repository.CurrentUserSessionDao;
import com.masai.repository.LoginDao;
import com.masai.repository.SignUpDao;




@Service
public class LogInServiceImpl implements LogInService{
	
	@Autowired
	private SignUpDao signUpDao;
	
	@Autowired
	private CurrentUserSessionDao currentUserSessionDao;
	
	@Autowired
	private CurrentUserSessionService currentUserSessionService;
	
	@Autowired
	private LoginDao loginDao;

	@Override
	public String logInAccount(Login login) throws LogInException {
		// TODO Auto-generated method stub
		Optional<SignUp> opt = signUpDao.findById(login.getUserId());
		
		if(!opt.isPresent()) {
			throw new LogInException("Invalid Login UserId");
		}
		SignUp newSignUp = opt.get();
		
		Integer newSignUpId = newSignUp.getUserId();
		
		Optional<CurrentUserSession> curretnUserOpt = currentUserSessionDao.findById(newSignUpId);
		
		if(curretnUserOpt.isPresent()) {
			throw new LogInException("User Already Login with this userId");
			

		}
		if((newSignUp.getUserId() == login.getUserId() && (newSignUp.getPassword().equals(login.getPassword())))){
			
			String key = RandomString.getRandomStringNumber();
			
			CurrentUserSession currentUserSession = new CurrentUserSession(newSignUp.getUserId(),newSignUpId, key,LocalDateTime.now());
			currentUserSessionDao.save(currentUserSession);
			loginDao.save(login);
			System.out.println(currentUserSession.toString());
			return currentUserSession.toString();
		}
		else
			throw new LogInException("Invalid username or password");

	}

	@Override
	public String logOutAccount(String key) throws LogInException {
		// TODO Auto-generated method stub
		Optional<CurrentUserSession> currentUserOptional = currentUserSessionDao.findByUserUniqueId(key);
		if(!currentUserOptional.isPresent())
		{
			throw new LogInException("User has not logged in with this UserId");
		}
		CurrentUserSession currentUserSession = currentUserSessionService.getCurrentUserSession(key);
		
		currentUserSessionDao.delete(currentUserSession);
		
		Optional<Login> loginData = loginDao.findById(currentUserOptional.get().getUserId());
		System.out.println(loginData);
		loginDao.delete(loginData.get());
		
		
		return "Logged Out......";
	}

}
