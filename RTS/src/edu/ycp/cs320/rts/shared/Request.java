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
public class Request implements Serializable, IsSerializable{
	private int userId;
	
	public Request(int userId){
		this.setUserId(userId);
	}
	public Request(){
		userId = 0;
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
