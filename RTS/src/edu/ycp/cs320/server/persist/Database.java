package edu.ycp.cs320.server.persist;


/**
 * @author dan
 *
 */
public class Database {
	// this is the line to change to reference derby database
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

