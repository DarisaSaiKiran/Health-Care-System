package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Integer id;
	private String profilePhotoURL;
	//@NotBlank(message = "username cannot be null")
	private String username;
	
	//@NotBlank(message = "password cannot be null")
	private String password;
	@Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}", flags = Pattern.Flag.CASE_INSENSITIVE)
	private String email;
	//@Range(min = 10, max = 10, message = "contact number should be exact 10 characters.")
	private String contact;
	
	private String gender;
	//@Min(value = 18, message = "Age should not be less than 18")
	//@Max(value = 100, message = "Age should not be greater than 100")
	private Integer age;
	//@NotBlank(message = "Role cannot be null")
	
	private String role;
	
	public enum userRole{
			ADMIN,USER
	}
	
	public enum gender {
		MALE, FEMALE
	}
	
	



}
