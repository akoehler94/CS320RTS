package edu.ycp.cs320.server.persist;

import java.util.ArrayList;

import edu.ycp.cs320.rts.shared.UserData;

public class FakeDatabase implements IDatabase {
	
	private ArrayList<UserData> users;
	
	public FakeDatabase() {
		users = new ArrayList<UserData>();
	}
	@Override
	public boolean createUser(UserData user) {
		boolean check = users.add(user);
		return check;
	}

	@Override
	public String Validatelogin(String username, String password) {
		
		for(UserData d: users){
			if(d.getUsername().equals(username)){
				
				//checks to see if the plain text password is a match to the hash in the database
				boolean check = BCrypt.checkpw(password, d.getPasswordhash());
				if(check){
					// if true, the function returns the username
					return d.getUsername();
				}
			}
		}
		//if false, it returns null
		return null;
	}

	

}
