package edu.ycp.cs320.rts.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rts.shared.Point;
import edu.ycp.cs320.rts.shared.Unit;

public class UnitTestdan {
	private Unit u1;
	@Before
	public void setUp() throws Exception {
		
		u1 = new Unit();
		u1.addWaypoint(new Point(5, 8));
		u1.addWaypoint(new Point(7, 22));
		u1.addWaypoint(new Point(2, 13));
	}

	@Test
	public void test() {
		assertEquals(u1.getNextWaypoint().getY(), 8);
		assertEquals(u1.getNextWaypoint().getX(), 7);
		u1.removeWaypoint();
		assertEquals(u1.getNextWaypoint().getY(), 22);
	}

}
