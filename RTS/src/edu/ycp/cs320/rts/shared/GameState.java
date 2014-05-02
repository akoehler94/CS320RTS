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
public class GameState implements IsSerializable, Cloneable{
	
	private ArrayList<GameObject> gameobjects;
	private TreeMap<String, Integer> resources;
	private ArrayList<MoveRequest> moveRequests;
	private ArrayList<BuildRequest> buildRequests;
	private ArrayList<AttackRequest> attackRequests;
	
	/**
	 * 
	 * @param objects
	 * @param userres
	 */
	public GameState(ArrayList<GameObject> objects, TreeMap<String, Integer> userres){
		setGameobjects(objects);
		setResources(userres);
		moveRequests = new ArrayList<MoveRequest>();
		buildRequests = new ArrayList<BuildRequest>();
		attackRequests = new ArrayList<AttackRequest>();
	}
	
	public GameState(GameState s){
//		this.gameobjects = (ArrayList<GameObject>) s.getGameobjects().clone();
//		this.resources = new TreeMap<String, Integer>();
//		for(String k: s.getResources().keySet()){
//			this.resources.put(k, s.getResources().get(k));
//		}
//		this.buildRequests = (ArrayList<BuildRequest>) s.getBuildRequests().clone();
//		this.attackRequests = (ArrayList<AttackRequest>) s.getAttackRequests().clone();
		this();
		this.gameobjects.addAll(s.gameobjects);
		this.resources.putAll(s.resources);
		this.moveRequests.addAll(s.moveRequests);
		this.buildRequests.addAll(s.buildRequests);
		this.attackRequests.addAll(s.attackRequests);
	}
	
	public GameState(){
		setGameobjects(new ArrayList<GameObject>());
		setResources(new TreeMap<String, Integer>());
		buildRequests = new ArrayList<BuildRequest>();
		moveRequests = new ArrayList<MoveRequest>();
		attackRequests =  new ArrayList<AttackRequest>();
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
	 * Adds a new movement requests
	 * 
	 * @param re
	 */
	public void addMoveRequests(ArrayList<MoveRequest> re){
		moveRequests.addAll(re);
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
	 * @param buildRequests the buildRequests to add
	 */
	public void addBuildRequests(ArrayList<BuildRequest> buildRequests) {
		this.buildRequests.addAll(buildRequests);
	}
	
	/**
	 * 
	 * @param req
	 */
	public void addBuildRequest(BuildRequest req){
		this.buildRequests.add(req);
	}

	/**
	 * @return the attackRequests
	 */
	public ArrayList<AttackRequest> getAttackRequests() {
		return attackRequests;
	}

	/**
	 * @param attackRequests the attackRequests to set
	 */
	public void setAttackRequests(ArrayList<AttackRequest> attackRequests) {
		this.attackRequests = attackRequests;
	}
	
	/**
	 * 
	 * @param req
	 */
	public void addAttackRequests(ArrayList<AttackRequest> req) {
		this.attackRequests.addAll(req);
	}
	
	
	public GameState clone() {
		
			GameState dup = new GameState(this);
			return dup;
			
		
	}

}
