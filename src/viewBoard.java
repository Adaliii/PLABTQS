import java.util.Arrays;

public class viewBoard{
	
	public void showBoardToPlayer(Board board) {
		System.out.println( "	A	B	C	D	E	F	G	H");
		
		for (int row = 0; row < board.getBoard().length; row++)//Cycles through rows
		{
			System.out.print( row+1 + "  "); 
			for (int col = 0; col < board.getBoard()[row].length; col++)//Cycles through columns
			{
				System.out.print(board.getBoard()[row][col] + " \t");;
			}
			System.out.println(); //Makes a new row
		}
		// Easier way to do it:
		//System.out.println( "   A      B      C      D      E      F      G      H");
		//System.out.println(Arrays.deepToString(board.getBoard()).replace("], ", "]\n"));
	}
	
	public void showBoardToEnemy(Board board) {
		System.out.println( "   A    B       C       D       E       F       G       H");
		
		for (int row = 0; row < board.getBoard().length; row++)//Cycles through rows
		{
			System.out.print( row+1 + " "); 
			for (int col = 0; col < board.getBoard()[row].length; col++)//Cycles through columns
			{
				if(board.getBoard()[row][col] == Board.cell.water || board.getBoard()[row][col] == Board.cell.boat){
					System.out.print(" \t");;
				}
				else {
					System.out.print(board.getBoard()[row][col] + " \t");;
				}
			}
			System.out.println(); //Makes a new row
		}
	}
	
	
}
