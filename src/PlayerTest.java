import static org.junit.Assert.*;

import org.junit.Test;

public class PlayerTest {

	// Test que comprova que els moviments dels jugadors són correctes.
	// Fa les proves de caixa negra:
	//	- Partició Equivalent, valors límits
	// Fa les proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage.
	@Test
	public void testMakeMoveMocked() {
		Player p = new Player("Juan", new MockBoard());
		Player p2 = new Player("Enemy",new MockBoard());
		ControllerGame gameControl = new ControllerGame();
		
		//Introduir llargada invalida (< 2), hauria de retornar 1
		assertEquals(p.makeMove(p2, "A"), 1);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "A"));
		//Introduir llargada invalida (> 2), hauria de retornar 1
		
		assertEquals(p.makeMove(p2, "AAA"), 1);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "AAA"));
		//Introduir columna incorrecte (No dins del rang A-H), hauria de retornar 2
		
		assertEquals(p.makeMove(p2, "M3"), 2);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "M3"));
		//Introduir fila incorrecte (No dins del rang 1-8) hauria de retornar 3
		
		assertEquals(p.makeMove(p2, "A9"), 3);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "A9"));
		//Introduir coordenada correcte, i fa hit (us de MockBoard), hauria de retornar 4
		
		assertEquals(p.makeMove(p2, "A3"), 4);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "A3"));
		//Introduir coordenada correcte, no fa hit (us de MockBoard), hauria de retornar 0
		
		assertEquals(p.makeMove(p2, "B6"), 0);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "B6"));
		
		//Introduir coordenada ja atacada
		assertEquals(p.makeMove(p2, "B6"), 5);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "B6"));
		
		assertEquals(p.makeMove(p2, "C3"), 0);
		gameControl.viewPlayer.showResultAttack(p.makeMove(p2, "B6"));
	}

}
