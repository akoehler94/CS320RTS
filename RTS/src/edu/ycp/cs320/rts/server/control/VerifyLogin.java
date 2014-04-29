package edu.ycp.cs320.rts.server.control;

import edu.ycp.cs320.server.persist.Database;
import edu.ycp.cs320.server.persist.IDatabase;

public class VerifyLogin {
	public String verifyLogin(String username, String password){
		IDatabase db = Database.getInstance();	
		return db.Validatelogin(username, password);
	}

}
