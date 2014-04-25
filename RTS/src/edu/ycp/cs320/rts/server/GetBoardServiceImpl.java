package edu.ycp.cs320.rts.server;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.rts.client.GetBoardService;
import edu.ycp.cs320.rts.server.control.AddChangesToGameState;
import edu.ycp.cs320.rts.server.control.ClientChannel;
import edu.ycp.cs320.rts.server.control.GameStateManager;
import edu.ycp.cs320.rts.server.control.GetGamestate;
import edu.ycp.cs320.rts.server.control.SetGameState;
import edu.ycp.cs320.rts.shared.BuildRequest;
import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Structure;

@SuppressWarnings("serial")
public class GetBoardServiceImpl extends RemoteServiceServlet implements GetBoardService {
	
	
	
	
	 public void init(ServletConfig config) throws ServletException {
		 super.init(config);
		 
		 
		 GameState state = new GetGamestate().getGameState();
		 GameStateManager manage = new GameStateManager(state);
		 
		// manage.start();
		 
	 }
	 
	public GameState exchangeGameState(GameState state){
		
		GetGamestate controller = new GetGamestate();
		//state = controller.getGameState();
		
		int i = (int) (Math.random() * 9);
		int j = (int) (Math.random() * 9);
		//System.out.println(i);
		
		int id = new Integer(""+ System.currentTimeMillis() % 1000000);
		
		Structure test = new Structure(id, 1, new Point(50*i, 50*j), new Point(
				128, 128), 1, 100);
		test.setImageName("structureSprite.png");
		
		//state.getGameobjects().add(test);
		
		state.addBuildRequest(new BuildRequest(1, new Point(2,2)));
		
		//ClientChannel channel = new ClientChannel();
		
		//state = channel.update(state);
		
		return state;
	}

	public Boolean login(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean newuser(String username, String password, String email) {
		// TODO Auto-generated method stub
		return null;
	}
}
