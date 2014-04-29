package edu.ycp.cs320.rts.server;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.ycp.cs320.rts.client.GetBoardService;
import edu.ycp.cs320.rts.server.control.AddChangesToGameState;
import edu.ycp.cs320.rts.server.control.AddUser;
import edu.ycp.cs320.rts.server.control.ClientChannel;
import edu.ycp.cs320.rts.server.control.GameStateManager;
import edu.ycp.cs320.rts.server.control.GetGamestate;
import edu.ycp.cs320.rts.server.control.SetGameState;
import edu.ycp.cs320.rts.server.control.VerifyLogin;
import edu.ycp.cs320.rts.shared.BuildRequest;
import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Structure;
import edu.ycp.cs320.server.persist.Database;
import edu.ycp.cs320.rts.shared.UserData;
import edu.ycp.cs320.server.persist.BCrypt;
@SuppressWarnings("serial")
public class GetBoardServiceImpl extends RemoteServiceServlet implements GetBoardService {
	
	private static GameStateManager manage;
	
	
	 public void init(ServletConfig config) throws ServletException {
		 super.init(config);
		 
		 
		 GameState state = new GetGamestate().getGameState();
		 manage = new GameStateManager(state);
		 System.out.println("Created GameStateManager");
		 
		manage.start();
		 
	 }
	 
	public GameState exchangeGameState(GameState state){
		
		ClientChannel channel;
		channel = (ClientChannel) getThreadLocalRequest().getSession().getAttribute("clientChannel");
		if (channel == null) {
			channel = manage.connect();
			getThreadLocalRequest().setAttribute("clientChannel", channel);
				
		}
		
		String username = (String)getThreadLocalRequest().getSession().getAttribute("username");
		if(username == null){
			//this should return null when login features are complete 
		}
		GetGamestate controller = new GetGamestate();
		//state = controller.getGameState();
		
		int i = (int) (Math.random() * 9);
		int j = (int) (Math.random() * 9);
		//System.out.println(i);
		
		int id = new Integer(""+ System.currentTimeMillis() % 1000000);
		
		Structure test = new Structure(id, 1, new Point(50*i, 50*j), new Point(
				128, 128), 1, 100);
		test.setImageName("structureSprite.png");
		
		if(state != null){
			state.getGameobjects().add(test);
			state.addBuildRequest(new BuildRequest(1, new Point(2,2)));
		}
		else{
			System.out.println("The game state is null");
		}
		
		
		
		
		state = channel.update(state);
		if (state == null) {
			System.out.println("Client channel update returned null?");
		}
		
		return state;
	}

	public Boolean login(String username, String password) {
		VerifyLogin logi = new VerifyLogin();
		String user = logi.verifyLogin(username, password);
		if(user == null){
			return false;
			
		}
		getThreadLocalRequest().setAttribute("username", user);
		return true;
	}

	public Boolean newuser(String username, String password, String email) {
		AddUser createuser = new AddUser();
		UserData user = new UserData(username, email, BCrypt.hashpw(password, BCrypt.gensalt()));
		return createuser.addUser(user);
	}
}
