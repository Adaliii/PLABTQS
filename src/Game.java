import java.io.IOException;
import java.util.Scanner;

public class Game {

	
	/*
	 * Main per jugar
	 */
	public static void main(String[] args) throws IOException {
		boolean continuePlaying = true;
		
		 
		while(continuePlaying) {
			ControllerGame controlGame = new ControllerGame();
			controlGame = new ControllerGame();
 			controlGame.setUpPlayers();
			controlGame.makeGame();
			boolean validContinue = false;
			while(!validContinue) {
				System.out.println("Vols jugar una altra partida? S/n");
				Scanner play = new Scanner(System.in);
				String next = play.nextLine();
				if(next.equals("n") || next.equals("N") || next.equals("S") || next.equals("s")) {
					validContinue = true;
					if(next.equals("n") || next.equals("N")) {
						continuePlaying = false;
						System.out.println("Joc acabat");
					}
					else {
						for(int i=0;i<40;i++) {
							System.out.println("\n");
						}
					}
				}
				
			}
			
		}
		
	}

}
