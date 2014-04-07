/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.util.ArrayList;
import java.util.TreeMap;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author dan
 *
 * Mar 31, 2014
 */
public class GameState implements IsSerializable{
	
	private ArrayList<GameObject> gameobjects;
	private TreeMap<String, Integer> resources;
	private ArrayList<MoveRequest> moveRequests;
	private ArrayList<BuildRequest> buildRequests;
	
	/**
	 * 
	 * @param objects
	 * @param userres
	 */
	public GameState(ArrayList<GameObject> objects, TreeMap<String, Integer> userres){
		setGameobjects(objects);
		setResources(userres);
	}
	
	public GameState(){
		setGameobjects(new ArrayList<GameObject>());
		setResources(new TreeMap<String, Integer>());
	}

	/**
	 * @return the gameobjects
	 */
	public ArrayList<GameObject> getGameobjects() {
		return gameobjects;
	}

	/**
	 * @param gameobjects the gameobjects to set
	 */
	public void setGameobjects(ArrayList<GameObject> gameobjects) {
		this.gameobjects = gameobjects;
	}

	/**
	 * @return the resources
	 */
	public TreeMap<String, Integer> getResources() {
		return resources;
	}

	/**
	 * @param resources the resources to set
	 */
	public void setResources(TreeMap<String, Integer> resources) {
		this.resources = resources;
	}

	/**
	 * @return the moveRequests
	 */
	public ArrayList<MoveRequest> getMoveRequests() {
		return moveRequests;
	}

	/**
	 * @param moveRequests the moveRequests to set
	 */
	public void setMoveRequests(ArrayList<MoveRequest> moveRequests) {
		this.moveRequests = moveRequests;
	}
	
	/**
	 * Adds a new movement request
	 * 
	 * @param re
	 */
	public void addMoveRequest(MoveRequest re){
		moveRequests.add(re);
	}

	/**
	 * @return the buildRequests
	 */
	public ArrayList<BuildRequest> getBuildRequests() {
		return buildRequests;
	}

	/**
	 * @param buildRequests the buildRequests to set
	 */
	public void setBuildRequests(ArrayList<BuildRequest> buildRequests) {
		this.buildRequests = buildRequests;
	}
	
	/**
	 * 
	 * @param req
	 */
	public void addBuildRequest(BuildRequest req){
		this.buildRequests.add(req);
	}
	

}
