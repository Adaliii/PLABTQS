import java.io.InputStream;
import java.util.*;  


public class Board {
	private int dimention;
	private Boat[] boats;
	private cell board[][]; // [row][column] == [number][letter] == position "3A"
	public enum cell{
		water,boat,hit,miss;		
	}
	
	public Board() {
		dimention = 8;
		this.board = new cell[dimention][dimention];
		for(int i=0;i<dimention;i++) {
			for(int j=0;j<dimention;j++) {
				board[i][j] = cell.water;
			}
		}
	}
	
	// buildBoat and insertBoat methods are separated for easier testing
	// Gets input from the player 
	public void buildBoard() {      
		Scanner scan = new Scanner(System.in);
		for(int i=0; i < boats.length; i++) {
			String[] str = new String [2];
			System.out.println("For size " + boats[i].getLength() + " boat: ");
			System.out.println("In what position do you want to put it? (A-H)+(1-8)");
			str[0] = scan.nextLine();
			System.out.println("In horitzontal or vertical orientation? (H/V)");
			str[1] = scan.nextLine();  
			if(str[1].equals("H")) {
				this.insertBoat(str[0], true, boats[i].getLength());
			}
			else {
				this.insertBoat(str[0], false, boats[i].getLength());
			}
		}
	    // Closing Scanner after the use
	    scan.close();
	}
	
	// Position a boat in board and returns false if position invalid (out of range) 
	public boolean insertBoat(String pos, boolean horizontal, int length ) {
		int[] intPos = this.convertStringToPosition(pos);
		if(horizontal) {
			if((intPos[0] + length) <= dimention) { // if not out of range letter
				for(int i =0; i < length; i++) {
					board[intPos[1]][intPos[0]+i]= cell.boat; // advance letter
				}
				return true;
			}
			else {
				return false;
			}
		}
		else { // vertical
			if((intPos[1] + length) <= dimention) { // if not out of range num
				for(int i =0; i < length; i++) {
					board[intPos[1]+i][intPos[0]]= cell.boat; // advance numA
				}
				return true;
			}
			else {
				return false;
			}
		}
	}
	
	public boolean makeMoveHit(String pos) {
		int[] intPos = this.convertStringToPosition(pos);
		if(board[intPos[1]][intPos[0]] == cell.boat) {
			board[intPos[1]][intPos[0]] = cell.hit;
			return true;
		}
		else if(board[intPos[1]][intPos[0]] == cell.water) {
			board[intPos[1]][intPos[0]] = cell.miss;
		}
		return false;
	}
	
	public boolean checkMoveEnfonsat(String pos) {
		
		return false;
	}
	
	public boolean checkWinner(){
		for(int i=0;i<dimention;i++) {
			for(int j=0;j<dimention;j++) {
				if(board[i][j] == cell.boat) {
					return false;
				}
			}
		}
		return true;
	}	
	
	public int getDimention() {
		return dimention;
	}
	
	public void setDimention(int dimention) {
		this.dimention = dimention;
	}
	
	public Boat[] getBoats() {
		return boats;
	}
	
	public void setBoats(Boat[] boats) {
		this.boats = boats;
	}
	
	public cell[][] getBoard() {
		return board;
	}
	
	public void setBoard(cell board[][]) {
		this.board = board;
	}
	
	public int[] convertStringToPosition(String casella) {
		int[] posicio = new int[2];
		
		posicio[0] = casella.charAt(0) - 65;
		posicio[1] = casella.charAt(1) - '1';
		return posicio;
	}
}
