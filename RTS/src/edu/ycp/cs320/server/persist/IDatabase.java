package edu.ycp.cs320.server.persist;

import edu.ycp.cs320.rts.shared.UserData;

public interface IDatabase {
	
	/**
	 * This meathod creates a new user in the database
	 * 
	 * 
	 * @param user the user to create
	 * @return if user was successfully created
	 */
	public boolean createUser(UserData user);
	
	/**
	 * This checks to see if the username 
	 * and sees if the password is a match
	 *  to the password_hash in the database
	 * 
	 * 
	 * @param username User's Name
	 * @param password the plain text password
	 * @return the username string
	 */
	public String Validatelogin(String username, String password);
}
