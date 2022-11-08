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
	
	public void testGetHit() {
		int length = 5;
		boolean[] state = new boolean[length];
		Arrays.fill(state, false);
		Boat b = new Boat(length);
		b.getHit(3);
		assertEquals(b.getState()[3], true);
		assertEquals(b.getState()[2], false);
	}
}
