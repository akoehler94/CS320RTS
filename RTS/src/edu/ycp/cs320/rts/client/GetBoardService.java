/**
 * 
 */
package edu.ycp.cs320.rts.client;

import java.awt.List;
import java.util.ArrayList;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.ycp.cs320.rts.shared.*;

/**
 * @author Dan
 *
 * Mar 26, 2014
 */
@RemoteServiceRelativePath("board")
public interface GetBoardService extends RemoteService {
	ArrayList<GameObject> getBoard(String username)  throws IllegalArgumentException;
}
