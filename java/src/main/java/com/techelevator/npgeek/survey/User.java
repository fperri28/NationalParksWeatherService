package com.techelevator.npgeek.survey;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class User {
	@NotBlank(message = "Email is required")
	@Email(message = "Please enter a valid email address")
	private String emailAddress;

	@NotBlank(message = "Password is required")
	private String password;

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
