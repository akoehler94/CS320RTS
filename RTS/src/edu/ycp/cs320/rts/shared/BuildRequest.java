/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author dan
 *
 * Apr 2, 2014
 */
@SuppressWarnings("serial")
public class BuildRequest extends Request implements Serializable, IsSerializable{
	
	private Point buildpoint;
	
	public BuildRequest(int userId, Point point) {
		super(userId);
		setBuildpoint(point);
	}
	
	public BuildRequest(){
		super();
		buildpoint = new Point();
		
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
