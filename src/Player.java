import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Player {
	String name;
	Board board;
	public Player() {
		name = "";
		board = new Board();
	}
	
	public Player(String name, Board board) {
		this.name = name;
		this.board = board;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board; 
	}
	
	public int makeMove(Player p, String atac) {
		if(atac.length() != 2) {
			return 1;
		}
		else {
			String columna = Character.toString(atac.charAt(1));
			String fila = Character.toString(atac.charAt(0));
			if(!columna.matches("^[A-H]$")) {
				return 2;
			}
			else if (!fila.matches("^[1-8]$")) {
				return 3;
			}
			else {
				if(p.board.makeMoveHit(atac)) {
					return 4;
				}
				else {
					return 0;
				}
				
			}
			
		}	
	}

	
}
