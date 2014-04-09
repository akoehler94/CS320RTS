/**
 * 
 */
package edu.ycp.cs320.rts.server.control;

import edu.ycp.cs320.rts.server.ISharedGamestate;
import edu.ycp.cs320.rts.server.SharedGamestate;
import edu.ycp.cs320.rts.shared.GameState;

/**
 * @author dan
 *
 * Apr 9, 2014
 */
public class AddChangesToGameState {
	public void addChangesToGameState(GameState gamestate){
		ISharedGamestate gs = SharedGamestate.getInstance();
		gs.addRequests(gamestate);
	}
}
