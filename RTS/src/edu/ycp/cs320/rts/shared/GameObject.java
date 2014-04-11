/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

/**
 * @author Dan
 * 
 *         Mar 13, 2014
 */
@SuppressWarnings("serial")
public class GameObject implements Serializable{
	private Point position;
	private Point size;
	private int owner;
	private int id;
	private String imageName;

	/**
	 * Creates a game object with initial values
	 * 
	 * @param id
	 * @param owner
	 * @param size
	 * @param pos
	 */
	public GameObject(int id, int owner, Point size, Point pos) {
		this.owner = owner;
		this.id = id;
		this.size = size;
		this.position = pos;
		imageName = new String(" ");

	}

	/**
	 * Creates an empty game object
	 */
	public GameObject() {
		this.owner = -1;
		this.id = -1;
		this.size = new Point();
		this.position = new Point();
		imageName = new String(" ");
	}

	/**
	 * @return the position
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position
	 *            the position to set
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return the size
	 */
	public Point getSize() {
		return size;
	}

	/**
	 * @param size
	 *            the size to set
	 */
	public void setSize(Point size) {
		this.size = size;
	}

	/**
	 * @return the owner
	 */
	public int getOwner() {
		return owner;
	}

	/**
	 * @param owner
	 *            the owner to set
	 */
	public void setOwner(int owner) {
		this.owner = owner;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	public boolean checkBounds(Point point){
		Point positiveCorner = getPosition();
		positiveCorner.add(getSize());//add the size to the position to get the corner opposite the origin
		if(point.getX()>=getPosition().getX()&&point.getX()<=positiveCorner.getX()&&point.getY()>=getPosition().getY()&&point.getY()<=positiveCorner.getY())
			return true;
		else 
			return false;
	}

}
