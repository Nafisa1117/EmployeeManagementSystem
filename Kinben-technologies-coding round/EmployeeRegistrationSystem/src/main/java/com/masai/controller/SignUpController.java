package com.masai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.exception.LogInException;
import com.masai.model.SignUp;
import com.masai.service.SignUpService;



@RestController
public class SignUpController {
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signUp")
	public ResponseEntity<SignUp> createNewSignUpHandler(@Valid @RequestBody SignUp newSignUp) throws LogInException {
		
		SignUp newSignedUp =signUpService.createNewSignUp(newSignUp);
		return new ResponseEntity<SignUp>(newSignedUp,HttpStatus.CREATED);

	}
	
	@PutMapping("/updateSignUp")
	public ResponseEntity<SignUp> updateSignUpDetailsHandler(@RequestBody SignUp signUp, @RequestParam String key) throws LogInException
	{
		SignUp newUpdatedSignUp = signUpService.updateSignUpDetails(signUp,key);
		
		return new ResponseEntity<SignUp>(newUpdatedSignUp,HttpStatus.ACCEPTED);
		
	
	}

}
