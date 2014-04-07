package edu.ycp.cs320.rts.server;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.rts.client.GetBoardService;

import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Structure;

@SuppressWarnings("serial")
public class GetBoardServiceImpl extends RemoteServiceServlet implements GetBoardService{
	
	public GameState exchangeGameState(GameState state){
		
		
		for(int i = 0; i < 5; i++){
			Structure test = new Structure(1, 1, new Point(i*100, 150), new Point(
					128, 128), 1, 100);
			test.setImageName("structureSprite.png");
			state.getGameobjects().add(test);
		}
		/*
		Structure test = new Structure(1, 1, new Point(150, 150), new Point(
				128, 128), 1, 100);
		test.setImageName("structureSprite.png");
		state.getGameobjects().add(test);
		*/
		System.out.println(state.getGameobjects().size());
		/*
		
		try {
		    Thread.sleep(10000);
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
		*/
		
		return state;	
	}
}
