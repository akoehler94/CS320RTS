package edu.ycp.cs320.rts.shared;

/**
 * 
 * 
 * @author jreichne
 *
 * Apr 9, 2014
 */
@SuppressWarnings("serial")
public class AttackVehicle extends Vehicle implements CanAttack {
	
	private int attackStrength;
	private int attackRange;
	private int cooldown;
	private long lastfiredtime;
	
	
	public AttackVehicle() {
		super();
		this.attackStrength = 0;
		this.attackRange = 0;
		this.lastfiredtime = 0;
		this.cooldown = 0;
		this.lastfiredtime = 0;
	}

	public AttackVehicle(boolean terrainType, int capacity, int id, int owner, Point size, Point pos, int health, int speed, int def, int cooldown, int strength, int range) {
		super(terrainType, capacity, id, owner, size, pos, health, speed, def);
		this.attackStrength = strength;
		this.attackRange = range;
		this.cooldown = cooldown;
		this.lastfiredtime = 0;
	}

	@Override
	public void setRange(int range) {
		this.attackRange = range;
		
	}

	@Override
	public void setCoolDown(int coolDown) {
		this.cooldown = coolDown;
	}

	@Override
	public int getAttackStrength() {
		return attackStrength;
	}

	@Override
	public int getRange() {
		return attackRange;
	}

	@Override
	public int getCoolDown() {
		return cooldown;
	}

	@Override
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


	
	public void setAttackStrength(int attackStrength) {
		this.attackStrength= attackStrength;
		
	}

	
	public boolean canAttack(long currenttime) {
		if((lastfiredtime-currenttime) > cooldown){
			return true;
		}
		return false;
	}


	
	public long lastFireTime() {
		return lastfiredtime;
	}

}
