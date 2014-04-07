/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

/**
 * @author dan
 *
 * Apr 2, 2014
 */
@SuppressWarnings("serial")
public class MoveRequest extends Request implements Serializable{
	private String unitId;
	private Point newWaypoint;
	
	/**
	 * 
	 * @param user
	 * @param target
	 * @param newPoint
	 */
	public MoveRequest(String user, String target, Point newPoint){
		super(user);
		unitId = target;
		newWaypoint = newPoint;
	}
	/**
	 * @return the unitId
	 */
	public String getUnitId() {
		return unitId;
	}
	/**
	 * @param unitId the unitId to set
	 */
	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	/**
	 * @return the newWaypoint
	 */
	public Point getNewWaypoint() {
		return newWaypoint;
	}
	/**
	 * @param newWaypoint the newWaypoint to set
	 */
	public void setNewWaypoint(Point newWaypoint) {
		this.newWaypoint = newWaypoint;
	}
	
	
	

}
