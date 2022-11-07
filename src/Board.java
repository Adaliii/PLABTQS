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
