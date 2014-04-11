package edu.ycp.cs320.rts.client;

import java.util.ArrayList;
import java.util.TreeMap;

import edu.ycp.cs320.rts.shared.Attackable;
import edu.ycp.cs320.rts.shared.CanAttack;
import edu.ycp.cs320.rts.shared.GameObject;
import edu.ycp.cs320.rts.shared.GameState;
import edu.ycp.cs320.rts.shared.Movable;
import edu.ycp.cs320.rts.shared.Point;

public class UIController {
	
	private GameState state = new GameState(new ArrayList<GameObject>(), new TreeMap<String, Integer>());
	private GameObject selectedObject;
	private int ownerID;
	
	public UIController(){
		
	}
	
	public void setGameState(GameState state){
		this.state=state;
	}
	
	/**
	 * Sets the selected object if the point was on a GameObject.
	 * 
	 * @param Takes a point to check with.
	 * 
	 * @return Returns true if an object was selected.
	 */
	public boolean determineSelect(Point click){
		GameObject currentObject=null;
		for(int i=0; i<state.getGameobjects().size();i++){
			currentObject=state.getGameobjects().get(i);
			if(currentObject.checkBounds(click)){
				this.selectedObject=currentObject;
				return true;
			}
		}
		return false;
	}
	/**
	 * Issues a command based on the click.
	 * 
	 * @param Takes a point to check with.
	 * 
	 * @return Returns 1 if an object issued an attack order, 0 if an object was issued a move order, and -1 if no order was issued..
	 */
	public int determineAction(Point click){
		GameObject targetObject=null;
		for(int i=0; i<state.getGameobjects().size();i++){
			targetObject=state.getGameobjects().get(i);
			if(targetObject.checkBounds(click)){
				this.selectedObject=targetObject;
			}
		}
		if(this.selectedObject!=null&&this.selectedObject.getOwner()==this.ownerID){
			if(targetObject!=null&&targetObject.getOwner()!=this.ownerID&&targetObject instanceof Attackable&&this.selectedObject instanceof CanAttack){
				
				
				return 1;
			}
			else{	
				if(selectedObject instanceof Movable)
					((Movable) selectedObject).addWaypoint(click);
				return 0;
			}
		}
		return-1;
	}
	public void setOwnerID(int id){
		this.ownerID=id;
	}
}
