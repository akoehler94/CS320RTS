package edu.ycp.cs320.rts.server;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.rts.shared.GameObject;

@SuppressWarnings("serial")
public class GetBoardServiceImpl extends RemoteServiceServlet {
	
	public ArrayList<GameObject> getBoard(String username) {
		
		
		return new ArrayList<GameObject>();
	}
}
