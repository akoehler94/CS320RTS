package edu.ycp.cs320.rts.server;

import edu.ycp.cs320.rts.shared.GameState;

public interface ISharedGamestate {
	/**
	 * 
	 * @return the shared GameState
	 */
	public GameState getSharedgamestate();
	/**
	 * 
	 * @param sharedgamestate to set
	 */
	public void setSharedgamestate(GameState sharedgamestate);
	/**
	 * 
	 * Adds the requests in the user's gamestate to the shared gamestate
	 * 
	 * 
	 * @param usergamestate
	 */
	public void addRequests(GameState usergamestate);
}
