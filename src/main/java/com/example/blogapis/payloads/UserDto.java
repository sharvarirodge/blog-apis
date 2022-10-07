 package com.example.blogapis.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class UserDto {

	
	private int id;
	
	@NotEmpty
	@Size(min = 4 , message = "Username must be min of 4 characters !")
	private String name;
	
	@Email(message = "Email address is not valid. Please enter in xyz@abc.com")
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 15, message = "Password must be minimum of 8 characters and maximum 15")
	private String password;
	
	@NotEmpty(message = "Let us know about you :)")
	private String about;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAbout() {
		return about;
	}
	
	public void setAbout(String about) {
		this.about = about;
	}
	
}
