package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {
	
	@Id
	@NotNull(message = "User ID must not be null value")
	private Integer userId;
	
	@NotNull(message = "User Name must not be null")
	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	
	@NotNull(message = "password must not be null")
	private String password;
	

}
