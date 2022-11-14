import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * La classe Player determina les accions de un jugador en el seu tauler.
 */
public class Player {
	String name;
	Board board;
	
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
	}
	
	public String getName() {
		return name;
	}

	public Board getBoard() {
		return board;
	}
	
	/**
 	* Permet fer un moviment al jugador en el tauler del enemic.
	*
	* @param  p	jugador al que li fa el moviment
	* @param  atac	posició on ataca el jugador
 	*/
	public int makeMove(Player p, String atac) {
		if(atac.length() != 2) {
			return 1;
		} 
		else {
			String columna = Character.toString(atac.charAt(0));
			String fila = Character.toString(atac.charAt(1));
			if(!columna.matches("^[A-H]$")) {
				return 2;
			}
			else if (!fila.matches("^[1-8]$")) {
				return 3;
			}
			else {
				int movehit = p.board.makeMoveHit(atac);
				if(movehit == 0) {
					return 4;
				}
				else if(movehit == 1){
					return 0;
				}
				else {
					return 5;
				}
				
			}
			
		}	
	}

	
}
