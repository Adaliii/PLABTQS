import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
	// Test del constructor, comprova que inicialitzi correctament tot el tauler amb aigua.
	@Test
	public void testBoard() { 
		Board board = new Board();
		for(int i = 0; i<8;i++) {
		    for(int j=0;j<8;j++) {
			assertTrue(board.getBoard()[i][j].equals(Board.cell.water));
		    }
		}
	}
	
	// Test que pasa posició string a array int, comprova que retorni la posició esperada.
	@Test
	public void testConvertLetter() {
		Board board = new Board();
		String lletra = "B1";
		int[] pos = new int[2];
		pos[0]=1; // letter
		pos[1]=0; // number
		assertArrayEquals(board.convertStringToPosition(lletra), pos);
	}
	
	// Test de getter i setter de les dimensions, comprova que es retorni el resultat esperat.
	@Test
	public void testGetSetDimention() {
		Board board = new Board();
		board.setDimention(3);
		assertEquals(board.getDimention(), 3);
	}
	
	// Test de l'inserció de barcos, insereix varis barcos i comprova si s'han col·locat correctament en el tauler.
	// Comprova situacions invalides de sobreposicio de barcos.
	// Fa proves de caixa negra on es comprova:
	//	- Partició Equivalent.
	// També realitza les proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage.
	@Test
	public void testInsertBoat() {
		Board board = new Board();
		String lletra = "B1";
		boolean orientation = false;
		int length = 3;
	    	board.insertBoat(lletra, orientation, length);
	    	assertEquals(board.getBoard()[0][1], Board.cell.boat); // B1
	    	assertEquals(board.getBoard()[1][1], Board.cell.boat); // B2
	    	assertEquals(board.getBoard()[2][1], Board.cell.boat); // B3
	    	assertFalse(board.insertBoat(lletra, orientation, length));
		Board board1 = new Board();
	    	board1.insertBoat("B1", true, 3); // insereix en B1 un barco horitzontal de llargada 3
	    	assertEquals(board1.getBoard()[0][1], Board.cell.boat); // B1
	    	assertEquals(board1.getBoard()[0][2], Board.cell.boat); // C1
	    	assertEquals(board1.getBoard()[0][3], Board.cell.boat); // D1
	    
	    	assertFalse(board1.insertBoat("B1", true, 3)); // barco ja inserit anteriorment
	    
		Board board2 = new Board();
	    	assertEquals(board2.insertBoat("F1", true, 3), true);
	
		Board board3 = new Board();
	    	assertEquals(board3.insertBoat("G1", true, 3), false);
	
		Board board4 = new Board();
	    	assertEquals(board4.insertBoat("F8", true, 3), true);
	
		Board board5 = new Board();
	    	assertEquals(board5.insertBoat("H1", false, 3), true);
	
		Board board6 = new Board();
	    	assertEquals(board6.insertBoat("H6", false, 3), true);
	
		Board board7 = new Board();
	    	assertEquals(board7.insertBoat("H7", false, 3), false);
	}
	
	// Test de la contrucció tauler a través de inserir barcos en varies posicions, invalides i correctes.
	// Aquestes posicions les rep del Mock de ViewBoard, que simulen posibles inputs dels jugadors.
	// Fa proves de caixa negra on es comprova:
	//	- Partició Equivalent, valors límit.
	// També realitza les proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage.
	@Test
	public void testBuildBoard() {
		
		Boat[] boats = new Boat[3];
		Boat b0 = new Boat(2);
		boats[0] = b0; // position = A2 H
		Boat b1 = new Boat(3);
		boats[1] = b1; // position = E3 V
 		Boat b2 = new Boat(3);
		boats[2] = b2; // position H6 V
		Board board = new Board();
		board.setBoats(boats);
		MockViewBoard mBoard = new MockViewBoard();
		board.viewBoard = mBoard;
		board.buildBoard();
		assertEquals(board.getBoard()[1][0], Board.cell.boat); // A2
		assertEquals(board.getBoard()[1][1], Board.cell.boat); // B2
		
		assertEquals(board.getBoard()[2][4], Board.cell.boat); // E3
		assertEquals(board.getBoard()[3][4], Board.cell.boat); // E4
		assertEquals(board.getBoard()[4][4], Board.cell.boat); // E5
		

		assertEquals(board.getBoard()[5][7], Board.cell.boat); // H6
		assertEquals(board.getBoard()[6][7], Board.cell.boat); // H7
		assertEquals(board.getBoard()[7][7], Board.cell.boat); // H8
		
		ViewBoard sb = new ViewBoard();
		sb.showBoardToPlayer(board);
		
		Boat[] boats4 = new Boat[1];
		Boat b04 = new Boat(2);
		boats4[0] = b04; // position = A2 H
		Board board4 = new Board();
		board4.setBoats(boats4);
		MockViewBoard mBoard4 = new MockViewBoard();
		mBoard4.numTest=1;
		board4.viewBoard = mBoard4;
		board4.buildBoard();
		assertEquals(board4.getBoard()[1][0], Board.cell.boat); // A2
		assertEquals(board4.getBoard()[1][1], Board.cell.boat); // B2
		
		ViewBoard sb4 = new ViewBoard();
		sb4.showBoardToPlayer(board4);
		
		Boat[] boats1 = new Boat[1];
		Boat b01 = new Boat(2);
		boats1[0] = b01; // position = A2 H
		Board board1 = new Board();
		board1.setBoats(boats1);
		MockViewBoard mBoard1 = new MockViewBoard();
		mBoard1.numTest=2;
		board1.viewBoard = mBoard1;
		board1.buildBoard();
		assertEquals(board1.getBoard()[1][0], Board.cell.boat); // A2
		assertEquals(board1.getBoard()[2][0], Board.cell.boat); // A3
		
		ViewBoard sb1 = new ViewBoard();
		sb1.showBoardToPlayer(board1);
	
		
		Boat[] boats2 = new Boat[1];
		Boat b02 = new Boat(2);
		boats2[0] = b02; // position = H8 V i després H7 V
		Board board2 = new Board();
		board2.setBoats(boats2);
		MockViewBoard mBoard2 = new MockViewBoard();
		mBoard2.numTest=3;
		board2.viewBoard = mBoard2;
		board2.buildBoard();
		assertEquals(board2.getBoard()[6][7], Board.cell.boat); // H7
		assertEquals(board2.getBoard()[7][7], Board.cell.boat); // H8
		
		ViewBoard sb2 = new ViewBoard();
		sb2.showBoardToPlayer(board2);
	
		
		Boat[] boats3 = new Boat[1];
		Boat b03 = new Boat(2);
		boats3[0] = b03; // position = H8 H i després G8 H
		Board board3 = new Board();
		board3.setBoats(boats3);
		MockViewBoard mBoard3 = new MockViewBoard();
		mBoard3.numTest=4;
		board3.viewBoard = mBoard3;
		board3.buildBoard();
		assertEquals(board3.getBoard()[7][6], Board.cell.boat); // G8
		assertEquals(board3.getBoard()[7][7], Board.cell.boat); // H8
		
		ViewBoard sb3 = new ViewBoard();
		sb3.showBoardToPlayer(board3);
	}
	
	// Test del moviment del jugador, fa diferents moviments vàlids i invalids sobre el tauler.
	// Comprova que repetir un moviment en una mateixa posició no afecti al tauler.
	// Fa proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage.
	@Test
	public void testMakeMove() {
		Board board = new Board();
		board.insertBoat("B1", true, 3);
		assertEquals(board.makeMoveHit("A1"), 1);
		assertEquals(board.makeMoveHit("A1"), 3); // ja ha fallat
		ViewBoard sb = new ViewBoard();
		sb.showBoardToEnemy(board);
		assertEquals(board.getBoard()[0][0], Board.cell.miss);
	
		Board board1 = new Board();
		board1.insertBoat("B1", false, 3);
		assertEquals(board1.makeMoveHit("B1"), 0);
		assertEquals(board1.makeMoveHit("B1"), 2); // ja li ha adonat
		ViewBoard sb1 = new ViewBoard();
		sb.showBoardToEnemy(board1);
		assertEquals(board1.getBoard()[0][1], Board.cell.hit);
	}
	
	// Test per mirar si hi ha guanyador, comprova que si es derriben tots els barcos el jugador guanyi i viceversa.
	// Fa proves de caixa blanca:
	// 	- Statement coverage, decision coverage, condition coverage.
	@Test
	public void testWinner() {
		Board board = new Board();
		board.insertBoat("B1", false, 1);
		board.makeMoveHit("B1");
		assertEquals(board.checkWinner(), true);
	
		Board board1 = new Board();
		board1.insertBoat("B1", false, 1);
		assertEquals(board1.checkWinner(), false);
	}

}
