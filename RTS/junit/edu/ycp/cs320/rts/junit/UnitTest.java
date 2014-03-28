package edu.ycp.cs320.rts.junit;

import static org.junit.Assert.*;

import java.util.PriorityQueue;

import org.apache.catalina.util.Queue;
import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Unit;

public class UnitTest {
	private Unit u1, u2;
	
	@Before
	public void setUp() throws Exception {
		u1 = new Unit(1, 1, new Point(1,1), new Point(0,0), 100, 3, 25);
		u2 = new Unit(2, 2, new Point(1,1), new Point(10,0), 100, 3, 25);
	}
	
	@Test
	public void testInitial() {
		assertEquals(100, u1.getMaxHealth());
		assertEquals(100, u1.getHealth());
		assertEquals(25, u1.getDefense());
		assertEquals(3, u1.getSpeed());
		assertEquals(1, u1.getId());
		assertEquals(0, u1.getPosition().getX());
		assertEquals(0, u1.getPosition().getY());
		assertEquals(null, u1.getNextWaypoint());
	}
	
	@Test												
	public void testAddWaypoint() {
		Point waypoint1 = new Point(10,0);
		Point waypoint2 = new Point(10,10);
		u1.addWaypoint(waypoint1);
		assertEquals(waypoint1.getX(), u1.getNextWaypoint().getX());
		assertEquals(waypoint1.getY(), u1.getNextWaypoint().getY());
		u1.addWaypoint(waypoint2);
		u1.removeWaypoint();
		assertEquals(waypoint2.getX(), u1.getNextWaypoint().getX());
		assertEquals(waypoint2.getY(), u1.getNextWaypoint().getY());
	}
	
	@Test
	public void testRemoveWaypoint() {
		Point waypoint1 = new Point(10,0);
		Point waypoint2 = new Point(10,10);
		u1.addWaypoint(waypoint1);
		u1.addWaypoint(waypoint2);
		u1.removeWaypoint();
		assertEquals(waypoint2.getX(), u1.getNextWaypoint().getX());
		assertEquals(waypoint2.getY(), u1.getNextWaypoint().getY());
		
	}
	
	@Test
	public void testClearWaypoints() {
		Point waypoint1 = new Point(10,0);
		Point waypoint2 = new Point(10,10);
		u1.addWaypoint(waypoint1);
		u1.addWaypoint(waypoint2);
		u1.clearWaypoints();
		assertEquals(null, u1.getNextWaypoint());
		
	}

}
