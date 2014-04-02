package edu.ycp.cs320.rts.shared;


import java.util.LinkedList;
import java.util.Queue;

public class Unit extends Interactable implements Movable, Attackable {
	
	private int speed;
	private Queue<Point> waypoints;
	
	// Constructor
	public Unit() {
		super();
		waypoints = new LinkedList<Point>();
		speed =1;
	}
	
	/**
	 * 
	 * @param id
	 * @param owner
	 * @param size
	 * @param pos
	 * @param health
	 * @param speed
	 * @param def
	 */
	public Unit(int id, int owner, Point size, Point pos, int health, int speed, int def) {
		super(id, owner, size, pos, def, health);
		waypoints = new LinkedList<Point>();
		this.speed = speed;
	}
	
	@Override
	public void addWaypoint(Point waypoint) {
		waypoints.add(waypoint);
	}

	@Override
	public void removeWaypoint() {
		waypoints.remove();
	}

	@Override
	public Point getNextWaypoint() {
		return waypoints.peek();
	}

	@Override
	public void clearWaypoints() {
		waypoints.clear();
	}


	@Override
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

	@Override
	public Queue<Point> getWaypoints() {
		
		return waypoints;
	}

	
}
