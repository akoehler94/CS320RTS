package edu.ycp.cs320.server.persist;

import edu.ycp.cs320.rts.shared.UserData;

public class FakeDatabase implements IDatabase {

	@Override
	public boolean createUser(UserData user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String Validatelogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

}
