/**
 * 
 */
package edu.ycp.cs320.server.persist;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		
		PreparedStatement createUser = null;
		try {
			// Set up connection 
			//you need the full path to db to work
			Connection conn = DriverManager.getConnection("jdbc:derby:/Users/dan/Documents/cs320workspace/CS320RTS/RTS/userdata.db;create=true");
			// Prepare insert statement and execute
			createUser = conn.prepareStatement("insert into userdata values (?, ?, ?)");
			createUser.setString(1, user.getUsername());
			createUser.setString(2, user.getEmail());
			createUser.setString(3, user.getPasswordhash());
			createUser.addBatch();
			createUser.executeBatch();
			
			return true;
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		finally {	// close the prepared statement
			if (createUser != null) {
				try {
					createUser.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
		
		
		
		return false;
	}

	/* (non-Javadoc)
	 * @see edu.ycp.cs320.server.persist.IDatabase#Validatelogin(java.lang.String, java.lang.String)
	 */
	@Override
	public String Validatelogin(String username, String password) {
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		
		try {
			
			// Set up connection 
			//you need the full path to get the db to work correctly
			Connection conn = DriverManager.getConnection("jdbc:derby:/Users/dan/Documents/cs320workspace/CS320RTS/RTS/userdata.db;create=true");
			// Prepare select statement that gets the password hash stored in the database for the given username
			stmt = conn.prepareStatement(
					" select username, password " +
					" from userdata " +
					" where userdata.username = ?"		
			);
			stmt.setString(1, username);
			
			resultSet = stmt.executeQuery();
			// Compare the password in the database to the password input by user for given username
			while (resultSet.next()) {
				String password_hash = resultSet.getString(2);
				
				boolean check = BCrypt.checkpw(password, password_hash);
				if (check) {
					
					return resultSet.getString(1);
				}
			}
			return null;
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
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					// ignore
				}
			}
		}
			
			
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
					"	username varchar(100) primary key," +
					"	email varchar(100)," +
					"	password varchar(100)" +
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
