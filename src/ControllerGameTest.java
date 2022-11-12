import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ControllerGameTest {
 
	@Test
	public void testMakeGameWithMock() throws IOException {
		ControllerGame game = new ControllerGame();
		Player players[] = new Player[2];
		players[0] = new Player("Winner", new MockBoard());
		Player enemy = new Player();
		enemy.setBoard(new MockBoard());
		enemy.setName("Enemy");
		players[1] = enemy;
		game.setPlayers(players);
		
		
		//Flux del joc: Winner ataca a 3A i guanya automaticament
		Player winner = game.makeGame();
		assertEquals(winner.getName(), "Winner");
		
		//Flux del joc: Winner ataca a 6B, falla, Enemy ataca a 3A, guanya
		ControllerGame game2 = new ControllerGame();
		players[0] = new Player("Winner", new MockBoard());
		enemy.setBoard(new MockBoard());
		enemy.setName("Enemy");
		players[1] = enemy;
		game2.setPlayers(players);
		
		Player winner2 = game2.makeGame();
		assertEquals(winner2.getName(), "Enemy");
	}

}
