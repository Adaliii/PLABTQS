import java.util.Scanner;

public class ViewBoard{
	
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
	public String askPositionBoat(int boatLength) {
		Scanner scan = new Scanner(System.in);
		String position = "";
		System.out.println("For size " + boatLength + " boat: ");
		System.out.println("In what position do you want to put it? (A-H)+(1-8)");
		position = scan.nextLine();
		return position;
	}

	public void showErrorPosition(String position) {
		System.out.println("Position " + position + " is not a valid coordinate");
		return;		
	}

	public String askOrientation() {
		Scanner scan = new Scanner(System.in);
		String orientation = "";
		System.out.println("In horitzontal or vertical orientation? (H/V)");
		orientation = scan.nextLine();
		return orientation;
	}

	public void showErrorOrientation(String orientation) {
		System.out.println("Orientation " + orientation + " is not a valid orientation");
		return;		
	}

	public void showBoatError() {
		System.out.println("Boat could not be inserted, try again");
		return;
	}
	
}
