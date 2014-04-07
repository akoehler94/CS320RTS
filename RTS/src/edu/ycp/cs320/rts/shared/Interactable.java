/**
 * 
 */
package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

import edu.ycp.cs320.rts.shared.Attackable;
import edu.ycp.cs320.rts.shared.GameObject;
import edu.ycp.cs320.rts.shared.Point;

/**
 * @author Dan
 *
 * Mar 15, 2014
 */
@SuppressWarnings("serial")
public class Interactable extends GameObject implements Attackable, Serializable{
	
	private int defence;
	private int health;
	private int maxHealth;
	
	/**
	 * 
	 */
	public Interactable(){
		super();
	}
	
	/**
	 * 
	 * @param id
	 * @param owner
	 * @param size
	 * @param pos
	 */
	public Interactable(int id, int owner, Point size, Point pos, int def, int health){
		super(id, owner, size, pos);
		this.defence=def;
		this.maxHealth=health;
		this.health=this.maxHealth;
	}

	@Override
	public void damage(int damage) {
		this.health -= damage;	
		if(health <= 0){
			death();
		}
	}

	@Override
	public void setDefense(int defense) {
		this.defence = defense;
		
	}

	@Override
	public int getDefense() {
		return defence;
	}

	@Override
	public int getHealth() {
		return health;
	}

	@Override
	public void death() {
		health = 0;
		
	}

	@Override
	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public boolean isAlive() {
		if(health > 0){
			return true;
		}
		return false;
	}

}
