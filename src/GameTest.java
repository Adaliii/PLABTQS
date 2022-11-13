import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class GameTest {

	@Test
	public void testGame() throws IOException {
		Game game = new Game();
		game.main();
	}

}
