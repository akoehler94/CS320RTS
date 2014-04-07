package edu.ycp.cs320.rts.shared;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Turret extends Structure implements CanAttack, Serializable {
	private int attackStrength;
	private int attackRange;
	private int cooldown;
	private long lastfiredtime;
	
	public Turret(){
		super();
		this.attackStrength = 0;
		this.attackRange = 0;
		this.lastfiredtime = 0;
		this.cooldown = 0;
		this.lastfiredtime = 0;
	}
	
	/**
	 * 
	 * @param id
	 * @param owner
	 * @param pos
	 * @param size
	 * @param def
	 * @param health
	 * @param attackStrength
	 * @param range
	 * @param cool
	 */
	public Turret(int id, int owner, Point pos, Point size, int def, int health,int attackStrength, int range, int cool){
		super(id, owner, pos, size, def, health);
		this.attackStrength = attackStrength;
		lastfiredtime =0;
		cooldown = cool;
		attackRange = range;
	}
	/**
	 * 
	 * @param AttackStrength
	 */
	public void setAttackStrength(int attackStrength){
		this.attackStrength = attackStrength;
	}
	/**
	 * 
	 * @return
	 */
	public int getAttackStrength(){
		return this.attackStrength;
	}
	/**
	 * 
	 * @param Range
	 */
	public void setRange(int range){
		this.attackRange = range;
	}
	/**
	 * 
	 * @return
	 */
	public int getRange(){
		return this.attackRange;
	}
	
	public void setCoolDown(int coolDown) {
		this.cooldown = coolDown;
	}
	
	public int getCoolDown() {
		return this.cooldown;
	}

	public boolean attack(Interactable target, long currenttime) {
		int dam = getAttackStrength() - target.getDefense();
		if(dam <= 0){
			dam=1;
		}
		target.damage(dam);
		lastfiredtime = currenttime;
	
		if(target.isAlive()){
			return false;
		}
		return true;
	}

	public boolean canAttack(long currenttime) {
		if((lastfiredtime-currenttime) > cooldown){
			return true;
		}
		return false;
	}

	@Override
	public long lastFireTime() {
		return lastfiredtime;
	}
}
