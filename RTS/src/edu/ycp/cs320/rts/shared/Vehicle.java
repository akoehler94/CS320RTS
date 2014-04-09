package edu.ycp.cs320.rts.shared;

import java.util.ArrayList;

/**
 * 
 * 
 * @author jreichne
 *
 * Apr 9, 2014
 */
@SuppressWarnings("serial")
public class Vehicle extends Unit implements CanTransport {
	
	private boolean IsLand;
	private int carryingCapacity;
	private ArrayList<Unit> passengers;
	
	public Vehicle() {
		super();
		IsLand = true;
		carryingCapacity = 0;
	}
	
	public Vehicle(boolean terrainType, int capacity, int id, int owner, Point size, Point pos, int health, int speed, int def) {
		super(id, owner, size, pos, health, speed, def);
		carryingCapacity = capacity;
		this.IsLand = terrainType;
	}

	@Override
	public void setCarryingCapacity(int carryingCapacity) {
		this.carryingCapacity = carryingCapacity;
	}

	@Override
	public int getCarryingCapacity() {
		return carryingCapacity;
	}

	@Override
	public ArrayList<Unit> getPassenger() {
		return passengers;
	}

	@Override
	public void load(Unit unit) {
		if (passengers.size() < carryingCapacity) {
			passengers.add(unit);
		}	
	}

	@Override
	public void unload(ArrayList<Unit> unit) {
		for (int i=0; i<unit.size(); i++) {
			passengers.remove(unit.get(i));
		}
	}

	@Override
	public void unloadAll() {
		passengers.removeAll(passengers);
	}
	
	public boolean isLand() {
		return IsLand;
	}

}
