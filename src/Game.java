import java.io.IOException;
import java.util.Scanner;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * La classe Game es on es troba el main, des d'on comença tot el joc.
 */
public class Game {
	public ControllerGame controlGame = new ControllerGame();
	
	
	/**
   	* Main on es criden els metodes necessaris per executar el joc.
 	*/
	public void main() throws IOException {
		boolean continuePlaying = true;
		
		 
		while(continuePlaying) {
			controlGame = new ControllerGame();
 			controlGame.setUpPlayers();
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

