/**
 * 
 */
package edu.ycp.cs320.server.persist;


/**
 * @author dan
 *
 */
public class HashLoginData {
	/**
	 * 
	 * @param data
	 * @return the hash of the data inputed
	 */
	public static String hashData(String data){
		return BCrypt.hashpw(data, BCrypt.gensalt());	
	}
}
