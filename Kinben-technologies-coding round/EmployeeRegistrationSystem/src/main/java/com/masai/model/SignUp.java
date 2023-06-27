package com.masai.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.Email;
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
@Inheritance(strategy=InheritanceType.JOINED)
public class SignUp {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	
	@NotNull(message = "User Name must not be null")
	@Pattern(regexp="[a-z]{6,12}", message = "Username must be between 6 to 12 characters. Must only contain lowercase characters.")
	private String userName;
	
	@NotNull(message = "Password must not be null...")
	private String password;
	
	@NotNull(message = "Mobile number must not be null in Signup")
	@Pattern(regexp="[0-9]{10}", message = "Mobile number must have 10 digits")
	private String mobile;
	
	@Email
	private String email;
	
	@Embedded
	private Address address;
	

}
