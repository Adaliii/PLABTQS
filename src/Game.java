import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;


public class Game {
	public ControllerGame controlGame = new ControllerGame();
	
	
	//No forma part dels tests
	@Test
	public void main() throws IOException {
		boolean continuePlaying = true;
		
		
		while(continuePlaying) {
			controlGame = new ControllerGame();
			controlGame.setUpGame();
			controlGame.makeGame();
			System.out.println("Vols jugar una altra partida? S/n");
			Scanner play = new Scanner(System.in);
			String next = play.nextLine();
			if(next.equals("n") || next.equals("N")) {
				continuePlaying = false;
			}
		}
		
	}
}
