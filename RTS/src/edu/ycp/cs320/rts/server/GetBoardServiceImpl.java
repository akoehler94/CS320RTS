package edu.ycp.cs320.rts.server;



import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.rts.client.GetBoardService;
import edu.ycp.cs320.rts.server.control.AddChangesToGameState;
import edu.ycp.cs320.rts.server.control.GetGamestate;
import edu.ycp.cs320.rts.server.control.SetGameState;
import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Structure;

@SuppressWarnings("serial")
public class GetBoardServiceImpl extends RemoteServiceServlet implements GetBoardService{
	
	public GameState exchangeGameState(GameState state){
		
		GetGamestate controller = new GetGamestate();
		//state = controller.getGameState();
		
		int i = (int) (Math.random() * 9);
		int j = (int) (Math.random() * 9);
		//System.out.println(i);
		
		Structure test = new Structure(i, 1, new Point(50*i, 50*j), new Point(
				128, 128), 1, 100);
		test.setImageName("structureSprite.png");
		
		//controller.getGameState().getGameobjects().add(test);
		
		state.getGameobjects().add(test);
		return state;
		//return controller.getGameState();	
	}
}
