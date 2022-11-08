import java.util.Arrays;


public class Board {
	private static int dimention;
	private Boat[] boats;
	private cell board[][];
	public enum cell{
		water,boat,hit;		
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
	
	// Position a boat in board 
	public void insertBoat(String pos, boolean horizontal, int length ) {
		int[] intPos = this.convertStringToPosition(pos);
		if(horizontal) {
			if((intPos[1] + length) < dimention) { // if not out of range
				for(int i =0; i < length; i++) {
					board[intPos[0]][intPos[1]+i]= cell.boat;
				}
			}
		}
		else { // vertical
			if((intPos[0] + length) < dimention) { // if not out of range
				for(int i =0; i < length; i++) {
					board[intPos[0]+i][intPos[1]]= cell.boat;
				}
			}
		}
	}
	
	public boolean makeMoveHit(String pos) {
		int[] intPos = this.convertStringToPosition(pos);
		if(board[intPos[0]][intPos[1]] == cell.boat) {
			board[intPos[0]][intPos[1]] = cell.hit;
			return true;
		}
		else if(board[intPos[0]][intPos[1]] == cell.water) {
			board[intPos[0]][intPos[1]] = cell.miss;
		}
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
	
	public static int getDimention() {
		return dimention;
	}
	public static void setDimention(int dimention) {
		Board.dimention = dimention;
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
