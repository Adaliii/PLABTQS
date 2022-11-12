import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	@Test
	public void testMakeMoveMocked() {
		Player p = new Player("Juan", new Board());
		Player p2 = new Player();
		p2.setBoard(new MockBoard());
		p2.setName("Enemy");
		
		//Introduir llargada invalida (< 2), hauria de retornar 1
		assertEquals(p.makeMove(p2, "A"), 1);
		
		//Introduir llargada invalida (> 2), hauria de retornar 1
		
		assertEquals(p.makeMove(p2, "AAA"), 1);
		
		//Introduir columna incorrecte (No dins del rang A-H), hauria de retornar 2
		
		assertEquals(p.makeMove(p2, "3M"), 2);
		
		//Introduir fila incorrecte (No dins del rang 1-8) hauria de retornar 3
		
		assertEquals(p.makeMove(p2, "9A"), 3);
		
		//Introduir coordenada correcte, i fa hit (us de MockBoard), hauria de retornar 4
		
		assertEquals(p.makeMove(p2, "3A"), 4);
		
		//Introduir coordenada correcte, no fa hit (us de MockBoard), hauria de retornar 0
		
		assertEquals(p.makeMove(p2, "6B"), 0);
	}

}
