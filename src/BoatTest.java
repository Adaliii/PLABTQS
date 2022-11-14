import static org.junit.Assert.*;


import java.util.Arrays;

import org.junit.Test;

public class BoatTest {
	// Test constructor, emmagatzema les dades inicialitzades del barco en els seus atributs
	// Fa servir proves de caixa blanca:
	//	- Loop testing (simple), decision coverage, condition coverage.
	// Fa serivir proves de caixa negre:
	//	- Partició equivalent, valors límits.
	@Test
	public void testBoat() {
		int length = 0;
		boolean[] state0 = new boolean[length];
		Arrays.fill(state0, false);
		Boat b0 = new Boat(length);
		assertEquals(b0.getLength(), 0, 0);
		
		boolean[] state = new boolean[1];
		Arrays.fill(state, false);
		Boat b1 = new Boat(1);
		assertEquals(b1.getLength(), 1, 0);
		assertArrayEquals(b1.getState(), state);
		
		boolean[] state2 = new boolean[2];
		Arrays.fill(state2, false);
		Boat b2 = new Boat(2);
		assertEquals(b2.getLength(), 2, 0);
		assertArrayEquals(b2.getState(), state2);
		
		boolean[] state5 = new boolean[5];
		Arrays.fill(state5, false);
		Boat b5 = new Boat(5);
		assertEquals(b5.getLength(), 5, 0);
		assertArrayEquals(b5.getState(), state5);
		
		boolean[] state7 = new boolean[7];
		Arrays.fill(state7, false);
		Boat b7 = new Boat(7);
		assertEquals(b7.getLength(), 7, 0);
		assertArrayEquals(b7.getState(), state7);
		
		boolean[] state8 = new boolean[8];
		Arrays.fill(state8, false);
		Boat b8 = new Boat(8);
		assertEquals(b8.getLength(), 8, 0);
		assertArrayEquals(b8.getState(), state8);

		Arrays.fill(state8, false);
		Boat b9 = new Boat(9);
		assertEquals(b9.getLength(), 0, 0);
	} 
	
	// Test de getter/setter de posicions, comrpova que retorna el resultat esperat.
	@Test
	public void testGetSetPositions() {
		Boat b = new Boat(3);
		String s [] = {"A1", "A2", "A3"};
		b.setPosition(s);
		assertArrayEquals(b.getPosition(), s);
	}
	
	// Test de updateHit, comprova que l'estat de la posició atacada sigui l'esperat despres de fer un moviment.
	// També comrpova que, si el moviment es fa en una posició en la que no esta el barco, no afecti els estats.
	// Fa proves de caixa negra:
	//	- Partició equivalent, valors límit.
	// Fa proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage, path coverage.
	@Test
	public void testGetHit() {
		Boat b = new Boat(3);
		String[] s = {"A1", "A2", "A3"};
		b.setPosition(s);
		b.updateHit("A1");
		b.updateHit("B1");
		b.updateHit("A4");
		assertEquals(b.getState()[2], false);
		assertEquals(b.getState()[1], false);
		assertEquals(b.getState()[0], true);
	}
	
	// Test comprovar si el barco esta enfonsat a través dels seus estats.
	// Fa proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage, path coverage.
	@Test
	public void testCheckEnfonsat() {
		Boat b = new Boat(2);
		String[] s = {"A1", "A2"};
		b.setPosition(s);
		b.updateHit("A1");
		b.updateHit("A2");
		assertTrue(b.checkEnfonsat());
		
		Boat b1 = new Boat(2);
		String[] s1 = {"A1", "A2"};
		b1.setPosition(s1);
		b1.updateHit("A1");
		assertFalse(b1.checkEnfonsat());
	}
}
