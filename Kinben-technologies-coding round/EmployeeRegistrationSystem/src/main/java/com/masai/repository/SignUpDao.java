package com.masai.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.SignUp;

public interface SignUpDao extends JpaRepository<SignUp, Integer>{

	public Optional<SignUp> findByUserName(String userName);
}
