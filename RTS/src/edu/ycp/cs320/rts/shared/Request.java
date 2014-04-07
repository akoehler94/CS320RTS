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
	private String userId;
	
	public Request(String userId){
		this.setUserId(userId);
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
