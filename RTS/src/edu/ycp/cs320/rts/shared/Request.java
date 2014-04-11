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
public class Request implements Serializable{
	private int userId;
	
	public Request(int userId){
		this.setUserId(userId);
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
