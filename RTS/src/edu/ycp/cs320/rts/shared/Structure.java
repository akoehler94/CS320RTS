package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Structure extends Interactable implements Serializable {
	
	/**
	 * 
	 */
	public Structure(){
		super();
	}
	
	
	/**
	 * 
	 * @param id
	 * @param owner
	 * @param pos
	 * @param size
	 * @param def
	 * @param health
	 */
	public Structure(int id, int owner, Point pos, Point size, int def, int health){
		super(id, owner, size, pos, def, health);
	}
}
