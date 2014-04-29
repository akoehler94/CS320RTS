/**
 * 
 */
package edu.ycp.cs320.server.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import edu.ycp.cs320.rts.shared.UserData;

/**
 * @author jreichne
 *
 * Apr 23, 2014
 */
public class DerbyDatabase implements IDatabase {

	// Load JDBC Driver
	static {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
		} catch (Exception e) {
			throw new IllegalStateException("Could not load Derby JDBC driver");
		}
	}
	
	
	/* (non-Javadoc)
	 * @see edu.ycp.cs320.server.persist.IDatabase#createUser(edu.ycp.cs320.rts.shared.UserData)
	 */
	@Override
	public boolean createUser(UserData user) {
		// 
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.server.persist.IDatabase#Validatelogin(java.lang.String, java.lang.String)
	 */
	@Override
	public String Validatelogin(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// The main method creates the database tables and loads the initial data.
	public static void main(String[] args) throws IOException {
		
		PreparedStatement stmt = null;
		
		try {
			// 1. Open a connection
			Connection conn = DriverManager.getConnection("jdbc:derby:userdata.db;create=true");
			System.out.println("Connected database successfully...");
			
			// 2. Execute a query to create userdata table
			stmt = conn.prepareStatement(
					" create table userdata (" +
					" 	id integer primary key," +
					"	username varchar(20)," +
					"	email varchar(20)," +
					"	password varchar(20)" +
					")");
			stmt.executeUpdate();
			System.out.println("Created table in given database...");
		} 
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}	
	}

}
