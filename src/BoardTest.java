import static org.junit.Assert.*;

import org.junit.Test;

//import Board.cell;



public class BoardTest {
	@Test
    public void testBoard() {
        Board board = new Board();
        for(int i = 0; i<8;i++) {
            for(int j=0;j<8;j++) {
                assertTrue(board.getBoard()[i][j].equals(Board.cell.water));
            }
        }
    }
	
	@Test
	public void testConvertLetter() {
		Board board = new Board();
		String lletra = "B1";
		int[] pos = new int[2];
		pos[0]=1; // letter
		pos[1]=0; // number
		assertArrayEquals(board.convertStringToPosition(lletra), pos);
	}
	
	@Test
	public void testGetSetDimention() {
		Board board = new Board();
		board.setDimention(3);
		assertEquals(board.getDimention(), 3);
	}
	
	@Test
	public void testVerticalInsertBoat() {
		Board board = new Board();
		String lletra = "B1";
		boolean orientation = false;
		int length = 3;
	    board.insertBoat(lletra, orientation, length);
	    assertEquals(board.getBoard()[0][1], Board.cell.boat); // B1
	    assertEquals(board.getBoard()[1][1], Board.cell.boat); // B2
	    assertEquals(board.getBoard()[2][1], Board.cell.boat); // B3
	}
	
	@Test
	public void testHorizontalInsertBoat() {
		Board board = new Board();
	    board.insertBoat("B1", true, 3); // insert in B1 a length 3 horizontal boat
	    assertEquals(board.getBoard()[0][1], Board.cell.boat); // B1
	    assertEquals(board.getBoard()[0][2], Board.cell.boat); // C1
	    assertEquals(board.getBoard()[0][3], Board.cell.boat); // D1
	}
	
	
	@Test
	public void testHorizontalInsertBoatLimitRight() {
		Board board = new Board();
	    assertEquals(board.insertBoat("F1", true, 3), true);
	}
	
	@Test
	public void testHorizontalInsertBoatLimitRightInvalid() {
		Board board = new Board();
	    assertEquals(board.insertBoat("G1", true, 3), false);
	}
	
	@Test
	public void testHorizontalInsertBoatLimitBottom() {
		Board board = new Board();
	    assertEquals(board.insertBoat("F8", true, 3), true);
	}
	
	@Test
	public void testVerticalInsertBoatLimitRight() {
		Board board = new Board();
	    assertEquals(board.insertBoat("H1", false, 3), true);
	}
	
	@Test
	public void testVerticalInsertBoatLimitBottom() {
		Board board = new Board();
	    assertEquals(board.insertBoat("H6", false, 3), true);
	}
	
	@Test
	public void testVerticalInsertBoatLimitBottomInvalid() {
		Board board = new Board();
	    assertEquals(board.insertBoat("H7", false, 3), false);
	}
	
	
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
	}
	
	
	@Test
	public void testMakeMoveMiss() {
		Board board = new Board();
		board.insertBoat("B1", true, 3);
		assertEquals(board.makeMoveHit("A1"), 1);
		assertEquals(board.makeMoveHit("A1"), 3); // already miss
		ViewBoard sb = new ViewBoard();
		sb.showBoardToEnemy(board);
		assertEquals(board.getBoard()[0][0], Board.cell.miss);
	}
	
	@Test
	public void testMakeMoveHit() {
		Board board = new Board();
		board.insertBoat("B1", false, 3);
		assertEquals(board.makeMoveHit("B1"), 0);
		assertEquals(board.makeMoveHit("B1"), 2); // already hit
		ViewBoard sb = new ViewBoard();
		sb.showBoardToEnemy(board);
		assertEquals(board.getBoard()[0][1], Board.cell.hit);
	}
	 
	@Test
	public void testWinner() {
		Board board = new Board();
		board.insertBoat("B1", false, 1);
		board.makeMoveHit("B1");
		assertEquals(board.checkWinner(), true);
	}
	
	@Test
	public void testNotWinner() {
		Board board = new Board();
		board.insertBoat("B1", false, 1);
		assertEquals(board.checkWinner(), false);
	}

}
