package edu.ycp.cs320.rts.junit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.rts.shared.GameObject;
import edu.ycp.cs320.rts.shared.Point;

public class GameObjectTest {
	private Point c1 = new Point(3,4);
	private Point c2 = new Point(106,2);
	private Point c3 = new Point(106,103);
	
	private GameObject p1 = new GameObject();
	private GameObject p2 = new GameObject();
	private GameObject p3 = new GameObject();

	@Before
	public void setUp() throws Exception {	
		p1.setPosition(new Point(0,0));
		p2.setPosition(new Point(10,10));
		p3.setPosition(new Point(99,99));
		
		p1.setSize(new Point(8,8));
		p2.setSize(new Point(32,32));
		p3.setSize(new Point(16,16));
	}

	@Test
	public void testP1() {
		assertEquals(true, p1.checkBounds(c1));
		assertEquals(false, p1.checkBounds(c2));
		assertEquals(false, p1.checkBounds(c3));
	}
	@Test
	public void testP2() {
		assertEquals(false, p2.checkBounds(c2));
		assertEquals(false, p2.checkBounds(c3));
		assertEquals(false, p2.checkBounds(c1));
	}
	@Test
	public void testP3() {
		assertEquals(false, p3.checkBounds(c1));
		assertEquals(true, p3.checkBounds(c3));
		assertEquals(false, p3.checkBounds(c2));
	}

}
