package edu.ycp.cs320.rts.server;


import java.util.ArrayList;

import edu.ycp.cs320.rts.shared.GameObject;
import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Unit;


public class ServerGame {
	
	private GameState gamestate;
	
	
	// Game Loop
	public void gameLoop() {
		
		float startT = System.currentTimeMillis();
		
		ArrayList<GameObject> gameObjects = gamestate.getGameobjects();
		
		for (GameObject o : gameObjects) {
			if (o.getClass() == Unit.class) {
				
			}
		}
		
		
		
		float finalT = System.currentTimeMillis() - startT;
	}
	
		
	



	/**
	 * Updates the server GameState by passing a new GameState
	 * 
	 * @param gamestate
	 */
	public void updateGameState(GameState gamestate) {
		this.gamestate = gamestate;
	}
}
