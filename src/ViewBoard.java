import java.util.Scanner;
/**
 * La classe ViewBoard es la vista de la classe Board, on es mostra el tauler i es fan els inputs dels jugadors.
 */
public class ViewBoard{
	
	/**
	 * Mostra el tauler del jugador al posicionar els barcos (cel·les boat i water)
	 *
	 * @param  board	El tauler que ha de mostrar
	 */
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
	}
	
	/**
	 * Mostra el tauler del jugador al enemic (cel·les miss i hit)
	 *
	 * @param  board	El tauler que ha de mostrar
	 */
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
	
	/**
	 * Demana al jugador les posicions dels barcos.
	 *
	 * @param  boatLength	llargada del barco que ha de posicionar
	 */
	public String askPositionBoat(int boatLength) {
		Scanner scan = new Scanner(System.in);
		String position = "";
		System.out.println("Pel barco de tamany: " + boatLength);
		System.out.println("En quina posició el vols col·locar? (A-H)+(1-8)");
		position = scan.nextLine();
		return position;
	}

	/**
	 * Mostra error de posició
	 *
	 * @param  position	La posicio erronea
	 */
	public void showErrorPosition(String position) {
		System.out.println("Posició " + position + " no es una coordenada vàlida.");
		return;		
	}

	public String askOrientation() {
		Scanner scan = new Scanner(System.in);
		String orientation = "";
		System.out.println("Esta en posicio horitzontal o vertical? (H/V)");
		orientation = scan.nextLine();
		return orientation;
	}

	/**
	 * Mostra error de orientació
	 *
	 * @param  position	La orientació erronea
	 */
	public void showErrorOrientation(String orientation) {
		System.out.println("L'orientació " + orientation + " no es vàlida.");
		return;		
	}

	/**
	 * Mostra error de l'inserció del barco.a
	 */
	public void showBoatError() {
		System.out.println("El barco no s'ha pogut inserir, tornau a intentar.");
		return;
	}
	
}
