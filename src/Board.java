import java.util.Arrays;


public class Board {
	private static int dimention = 10;
	private Boat[] boats;
	private cell board[][];
	public enum cell{
		water,boat,hit;		
	}
	public Board() {
		this.board = new cell[dimention][dimention];
		for(int i=0;i<10;i++) {
			Arrays.fill(board[i], cell.water);
		}
		
	}
	
	// Position a boat in board 
	public void insertBoat(String pos, boolean horizontal, int length ) {
		int[] intPos = this.convertStringToPosition(pos);
		if((intPos[0] + length) < dimention) { // if not out of range
			for(int i =0; i < length; i++) {
				board[intPos[0]+i][intPos[1]]= cell.boat;
			}
		}
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
