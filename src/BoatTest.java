import static org.junit.Assert.*;


import java.util.Arrays;

import org.junit.Test;

public class BoatTest {

	@Test
	public void testBoat() {
		int length = 5;
		boolean[] state = new boolean[length];
		Arrays.fill(state, false);
		Boat b = new Boat(length);
		assertEquals(b.getLength(), 5, 0);
		assertArrayEquals(b.getState(), state);
	}
	
	@Test
	public void testGetSetPositions() {
		Boat b = new Boat(3);
		String s [] = {"A1", "A2", "A3"};
		b.setPosition(s);
		assertArrayEquals(b.getPosition(), s);
	}
	
	@Test
	public void testGetHit() {
		Boat b = new Boat(3);
		String[] s = {"A1", "A2", "A3"};
		b.setPosition(s);
		b.updateHit("A1");
		assertEquals(b.getState()[2], false);
		assertEquals(b.getState()[1], false);
		assertEquals(b.getState()[0], true);
	}
	
	@Test
	public void testCheckEnfonsat() {
		Boat b = new Boat(2);
		String[] s = {"A1", "A2"};
		b.setPosition(s);
		b.updateHit("A1");
		b.updateHit("A2");
		assertEquals(b.checkEnfonsat(), true);
	}
}
