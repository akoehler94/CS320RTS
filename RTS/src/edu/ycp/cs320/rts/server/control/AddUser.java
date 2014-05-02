package edu.ycp.cs320.rts.server.control;

import edu.ycp.cs320.server.persist.Database;
import edu.ycp.cs320.server.persist.IDatabase;
import edu.ycp.cs320.rts.shared.UserData;


public class AddUser {
	public boolean addUser(UserData user) {
		IDatabase db = Database.getInstance();	
		return db.createUser(user);
	}

}
