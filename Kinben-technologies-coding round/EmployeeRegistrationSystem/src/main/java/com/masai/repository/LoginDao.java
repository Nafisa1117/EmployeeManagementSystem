package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.model.Login;

public interface LoginDao extends JpaRepository<Login, Integer>{

}
