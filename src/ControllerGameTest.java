import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class ControllerGameTest {
	
	@Test
	
	public void testMakeGameWithMock() throws IOException {
		ControllerGame game = new ControllerGame();
		Player players[] = new Player[2];
		game.players[0] = new Player("Winner", new MockBoard());
		Player enemy = new Player("Enemy",new MockBoard());
		game.players[1] = enemy;
		
		
		 
		//Flux del joc: Winner ataca a A3 i guanya automaticament
		Player winner = game.makeGame();
		assertEquals(winner.getName(), "Winner");
		
		//Flux del joc: Winner ataca a 6B, falla, Enemy ataca a 3A, guanya
		ControllerGame game2 = new ControllerGame();
		game2.players[0] = new Player("Winner", new MockBoard());
		game2.players[1] = new Player("Enemy", new MockBoard());
		
		
		Player winner2 = game2.makeGame();
		assertEquals(winner2.getName(), "Enemy");
	}
	
	@Test
	public void gameSetUpTest() {
		ControllerGame game = new ControllerGame();
		game.viewPlayer = new MockViewPlayer();
		game.setUpPlayers();
		assertEquals(game.players[0].getName(), "Juan");
		assertEquals(game.players[1].getName(), "Alfonso");
		
		game.setUpPlayers();
		assertEquals(game.players[0].getName(), "Hola");
		assertEquals(game.players[1].getName(), "Hola");
		
	}
	

}
