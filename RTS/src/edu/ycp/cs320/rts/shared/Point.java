/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

import com.google.gwt.user.client.rpc.IsSerializable;

/**
 * @author Dan
 *
 * Mar 13, 2014
 */
@SuppressWarnings("serial")
public class Point implements Comparable<Point>, Serializable, IsSerializable{
	private int x;
	private int y;
	
	/**
	 *  Construtor with set values (x,y)
	 * @param x
	 * @param y
	 */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Creates point at (0,0)
	 */
	public Point(){
		x=0;
		y=0;
	}
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	/**
	 * @param x the x position to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	/**
	 * @param y the y position to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * adds the x and y components of the point and the parameter point
	 * stores the result in this point
	 * 
	 * @param p the point 
	 */
	public void add(Point p){
		this.x = p.getX() + this.x;
		this.y = p.getY() + this.y;
	}
	
	/**
	 * Returns an integer approximation of the distance between 2 points
	 * 
	 * @param p
	 * @return distance between points
	 */
	public int distTo(Point p){
		int dx = this.x - p.getX();
		int dy = this.y - p.getY();
		
		return (int) Math.sqrt((dx*dx)+(dy*dy));
	}

	@Override
	public int compareTo(Point o) {
		int x = o.getX() - this.getX();
		int y = o.getY() - this.getY();
		if(x==0 && y==0){
			return 0;
		}
		return x+y;
	}

}
