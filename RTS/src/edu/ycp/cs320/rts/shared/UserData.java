/**
 * 
 */
package edu.ycp.cs320.rts.shared;

/**
 * @author dan
 *
 * Apr 23, 2014
 */
public class UserData {
	
	private String username;
	private String email;
	private String passwordhash;
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the passwordhash
	 */
	public String getPasswordhash() {
		return passwordhash;
	}
	/**
	 * @param passwordhash the passwordhash to set
	 */
	public void setPasswordhash(String passwordhash) {
		this.passwordhash = passwordhash;
	}

}
