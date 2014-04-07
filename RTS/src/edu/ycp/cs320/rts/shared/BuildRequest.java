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
public class BuildRequest extends Request implements Serializable{
	
	private Point buildpoint;
	
	public BuildRequest(String userId, Point point) {
		super(userId);
		setBuildpoint(point);
	}

	/**
	 * @return the buildpoint
	 */
	public Point getBuildpoint() {
		return buildpoint;
	}

	/**
	 * @param buildpoint the buildpoint to set
	 */
	public void setBuildpoint(Point buildpoint) {
		this.buildpoint = buildpoint;
	}

	


}
