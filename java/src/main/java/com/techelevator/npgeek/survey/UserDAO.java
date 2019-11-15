package com.techelevator.npgeek.survey;

public interface UserDAO {

	// Create

	public User addUser(String emailAddress, String password);

	// Read

	public User getUser(String emailAddress, String password);

}
