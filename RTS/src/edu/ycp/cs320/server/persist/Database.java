package edu.ycp.cs320.server.persist;


/**
 * @author dan
 *
 */
public class Database {
private static final IDatabase theInstance = new FakeDatabase();
	
	/**
	 * Get the singleton {@link IDatabase} implementation.
	 * 
	 * @return the singleton {@link IDatabase} implementation
	 */
	public static IDatabase getInstance() {
		return theInstance;
	}
}

