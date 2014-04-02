package edu.ycp.cs320.rts.shared;

import java.util.ArrayList;
import java.util.Queue;


public interface Movable {
	
	/**
	 * 
	 * @param waypoint
	 */
	abstract void addWaypoint(Point waypoint);
	
	/**
	 * Removes top waypoint.
	 * 
	 */
	abstract void removeWaypoint();
	
	/**
	 * Returns object's current waypoints.
	 * 
	 * @return
	 */
	abstract Queue<Point> getWaypoints();
	
	/**
	 * Clears the object's waypoints.
	 */
	abstract void clearWaypoints();
	
	/**
	 * 
	 * @param speed
	 */
	abstract void setSpeed(int speed);
	
	/**
	 * Returns object's speed.
	 * 
	 * @return
	 */
	abstract int getSpeed();
	/**
	 * Gets the top waypoint without removing it
	 * 
	 * @return the next waypoint 
	 */
	abstract Point getNextWaypoint();
}
