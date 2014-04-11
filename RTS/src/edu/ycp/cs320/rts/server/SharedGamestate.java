/**
 * 
 */
package edu.ycp.cs320.rts.server;

/**
 * @author dan
 *
 * Apr 7, 2014
 */
public class SharedGamestate {
	private static final ISharedGamestate theinstance = new MemorySharedGamestate();
	
	public static ISharedGamestate getInstance() {
		return theinstance;
	}
}
