/**
 * 
 */
package edu.ycp.cs320.rts.client;

import java.awt.List;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.ycp.cs320.rts.shared.GameObject;

/**
 * @author Dan
 *
 * Mar 26, 2014
 */
public interface GetBoardServiceAsync {

	void getBoard(String username, AsyncCallback<ArrayList<GameObject>> callback);

}
