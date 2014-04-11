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
public class SetGameState {
	public void setGameState(GameState gameState){
		ISharedGamestate gs = SharedGamestate.getInstance();
		gs.setSharedgamestate(gameState);
	}
}
